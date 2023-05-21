package game.actors.enemies.skeleton;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actions.DeathAction;
import game.controllers.Resettable;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * Class that represents the PileOfBones actor which will spawn when a Skeleton dies
 *
 * @author Emily Jap
 * @version 2.0.0
 */
public class PileOfBones extends Actor implements RuneSource, Resettable {

    /**
     * The actor the PileOfBones will revive into when it is not hit.
     */
    private final Actor revivableActor;

    /**
     * A counter for keeping track of the number of turns before it revives.
     */
    private int counter;

    /**
     * Constructor that instantiates the pile of bones, removing its capabilties of behaving like a normal alive actor.
     *
     * @param revivableActor the actor the pile of bones will revive into when it is not hit
     */
    public PileOfBones(Actor revivableActor) {
        super("Pile Of Bones", 'X', 1);
        this.revivableActor = revivableActor;
        removeCapability(Status.REVIVABLE);
        addRuneSource();

        // transfer inventory from revivable actor (to be dropped when pile of bones dies)
        for (WeaponItem weapon : revivableActor.getWeaponInventory()) {
            addWeaponToInventory(weapon);
        }
        for (Item item : revivableActor.getItemInventory()) {
            addItemToInventory(item);
        }

        counter = 0;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        counter += 1;

        // revive after 3 turns
        if (counter == 3) {
            // revive
            Location currentLocation = map.locationOf(this);
            map.removeActor(this);
            map.addActor(revivableActor, currentLocation);
        }

        // if hit, drop weapon
        if (!isConscious()) {
            RuneManager.getInstance().removeRuneSource(this);
            return new DeathAction(this);
        }

        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        // any actor can directly attack pile of bones
        actions.add(new AttackAction(this, direction));

        if (otherActor.getWeaponInventory() != null) {
            for (int i = 0; i < otherActor.getWeaponInventory().size(); i++) {
                actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(i)));
            }
        }

        if (otherActor.hasCapability(Status.PERFORM_AREA_ATTACK)) {

            // check for AOE weapons, otherwise use intrinsic weapon
            if (otherActor.getWeaponInventory() != null) {
                for (int i = 0; i < otherActor.getWeaponInventory().size(); i++) {
                    WeaponItem weapon = otherActor.getWeaponInventory().get(i);
                    if (weapon.hasCapability(Status.PERFORM_AREA_ATTACK)) {
                        actions.add(new AreaAttackAction(weapon));
                    }
                }
            } else {
                actions.add(new AreaAttackAction(otherActor.getIntrinsicWeapon()));
            }
        }
        return actions;
    }

    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(35, 892));
        runeManager.addRuneSource(this);
    }

    @Override
    public void reset() {
        this.addCapability(Status.RESETTABLE);
    }
}
