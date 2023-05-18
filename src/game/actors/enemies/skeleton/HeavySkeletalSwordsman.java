package game.actors.enemies.skeleton;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.skeleton.Skeleton;
import game.utils.Utils;
import game.actions.AreaAttackAction;
import game.actors.AttackType;
import game.behaviours.AreaAttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.utils.Status;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.items.weapons.Grossmesser;

import java.util.HashMap;


/**
 * Class that represents the Heavy Skeletal Swordsman extending from a skeleton
 * @author Emily Jap
 * @version 1.0.0
 * @see Skeleton
 */
public class HeavySkeletalSwordsman extends Skeleton {

    /**
     * Constructor that instantiates the actor with its starting weapon
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        addWeaponToInventory(new Grossmesser());
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map){

        // these behaviours occur when there are other actors in the surrounding area
        behaviours.put(600, new FollowBehaviour(otherActor));
        behaviours.put(10, new AttackBehaviour(new Grossmesser()));

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

        allowAreaAttack(otherActor, map, actions);
        return actions;
    }

}