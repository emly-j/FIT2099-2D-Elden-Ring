package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actors.AttackType;
import game.behaviours.AreaAttackBehaviour;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.items.weapons.Grossmesser;
import game.items.weapons.Scimitar;
import game.utils.Status;
import game.utils.Utils;

import java.util.HashMap;


/**
 * This class represents a base Skeletal Bandit
 * @author Hayden Tran
 * @version 1.0.0
 */
public class SkeletalBandit extends Skeleton{
    /**
     * Constructor that adds the required weapon Scimitar and instantiates the properties of the skeletal bandit
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184);
        addWeaponToInventory(new Scimitar());
    }

    /**
     * adds the required behaviours expected of an enemie
     * adds new actions based on the capability that the other actors have
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map){

        // these behaviours occur when there are other actors in the surrounding area
        behaviours.put(998, new FollowBehaviour(otherActor));
        behaviours.put(10, new AttackBehaviour());
        behaviours.put(11, new AreaAttackBehaviour(new Grossmesser()));

        ActionList actions= new ActionList();
        // actions the player or other enemy types can do to this actor
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && !otherActor.hasCapability(AttackType.CANNOT_ATTACK_SKELETONS)){
            actions.add(new AttackAction(this, direction));

            if(otherActor.getWeaponInventory() != null){
                for(int i = 0; i<otherActor.getWeaponInventory().size(); i++){
                    actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(i)));
                }
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
