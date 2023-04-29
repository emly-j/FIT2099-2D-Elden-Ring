package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.actions.AttackAction;
import game.actors.AttackType;
//import game.behaviours.AreaAttackBehaviour;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;

public class GiantCrab extends Crustacean {
    /**
     * Constructor.
     *
     */
    public GiantCrab() {
        super("Giant Crab", 'C', 407);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map){

        // these behaviours can occur when there are other actors in the surrounding area
        behaviours.put(998, new FollowBehaviour(otherActor));
        behaviours.put(2, new AttackBehaviour());
        //behaviours.put(3, new AreaAttackBehaviour());

        ActionList actions= new ActionList();
        // actions the player or other enemy types can do to this actor
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && !otherActor.hasCapability(AttackType.CANNOT_ATTACK_CRUSTACEANS)){
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

    @Override
    public void reset() {

    }
}
