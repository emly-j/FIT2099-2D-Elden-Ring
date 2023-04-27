package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.AttackType;
import game.behaviours.FollowBehaviour;
import game.Status;
import game.actions.AttackAction;
import game.behaviours.AreaAttackBehaviour;
import game.behaviours.AttackBehaviour;
import game.items.weapons.Grossmesser;
//import game.items.weapons.Grossmesser;

public class HeavySkeletalSwordsman extends Skeleton {

    /**
     * Constructor.
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        addWeaponToInventory(new Grossmesser());
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map){

        // these behaviours occur when there are other actors in the surrounding area
        behaviours.put(998, new FollowBehaviour(otherActor));
        behaviours.put(10, new AttackBehaviour());
        //behaviours.put(11, new AreaAttackBehaviour());

        ActionList actions= new ActionList();
        // actions the player or other enemy types can do to this actor
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && !otherActor.hasCapability(AttackType.CANNOT_ATTACK_SKELETONS)){
            actions.add(new AttackAction(this, direction));
            actions.add(new AttackAction(this, direction, otherActor.getIntrinsicWeapon()));

            if(otherActor.getWeaponInventory() != null){
                for(int i = 0; i<otherActor.getWeaponInventory().size(); i++){
                    actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(i)));
                }
            }
        }

        // TODO: add area attack action which anyone can do

        return actions;
    }
}
