package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.Utils;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actions.DeathAction;
import game.actors.AttackType;

import java.util.HashMap;

public class PileOfBones extends Actor{

    private Actor revivableActor;
    private int counter;

    /***
     * Constructor.
     */
    public PileOfBones(Actor revivableActor) {
        super("Pile Of Bones", 'X', 1);
        this.revivableActor = revivableActor;
        addCapability(AttackType.CANNOT_ATTACK_SKELETONS);

        // transfer inventory (to be dropped when pile of bones dies)
        addWeaponToInventory(revivableActor.getWeaponInventory().get(0)); // TODO: find another way to do this instead of hardcoding

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
            // TODO: runes transfer
            return new DeathAction(this);
        }

        return null;
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
}
