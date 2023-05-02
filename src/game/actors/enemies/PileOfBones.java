package game.actors.enemies;

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
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.utils.Utils;

import java.util.HashMap;

/**
 * Class that represents the PileOfBones actor which will spawn when a Skeleton dies
 * @author Emily Jap
 * @version 1.0.0
 */
public class PileOfBones extends Skeleton implements RuneSource {

    private Actor revivableActor;
    private int counter;

    /**
     * Constructor that instantiate sthe pile of bones, removing its capabilties of behaving like a normal alive actor
     * @param revivableActor the actor which is a skeleton that turns into this pile of bones
     */
    public PileOfBones(Actor revivableActor) {
        super("Pile Of Bones", 'X', 1);
        this.revivableActor = revivableActor;
        removeCapability(Status.REVIVABLE);
        behaviours.remove(1); // remove BecomePileOfBonesBehaviour
        behaviours.remove(999); // remove WanderBehaviour
        behaviours.remove(500); // remove AttackBehaviour
        addRuneSource();

        // transfer inventory (to be dropped when pile of bones dies)
        for (WeaponItem weapon : revivableActor.getWeaponInventory()){
            addWeaponToInventory(weapon);
        }
        for (Item item : revivableActor.getItemInventory()){
            addItemToInventory(item);
        }

        counter = 0;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        counter += 1;

        // revive after 3 turns
        if (counter == 3){
            // revive
            Location currentLocation = map.locationOf(this);
            map.removeActor(this);
            map.addActor(revivableActor, currentLocation);
        }

        // if hit, drop weapon
        if (!isConscious()){
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

        if(otherActor.getWeaponInventory() != null){
            for(int i = 0; i<otherActor.getWeaponInventory().size(); i++){
                actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(i)));
            }
        }

        // If player has a weapon with area attack capability, put area attack on list of allowable actions
        if(otherActor.hasCapability(Status.PERFORM_AREA_ATTACK)){
            HashMap<Actor, String> targets = Utils.getSurroundingActors(otherActor, map);
            // check for AOE weapons, otherwise use intrinsic weapon
            if(otherActor.getWeaponInventory() != null){
                for(int i = 0; i<otherActor.getWeaponInventory().size(); i++){
                    WeaponItem weapon = otherActor.getWeaponInventory().get(i);
                    if (weapon.hasCapability(Status.PERFORM_AREA_ATTACK)){
                        actions.add(new AreaAttackAction(targets, weapon));
                    }
                }
            }
        }

        return actions;
    }

    @Override
    public void reset() {

    }

    @Override
    public void addRuneSource(){
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(35, 892));
        runeManager.addRuneSource(this);
    }
}
