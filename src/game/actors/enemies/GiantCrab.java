package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actors.AttackType;
import game.behaviours.AreaAttackBehaviour;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.utils.Utils;

import java.util.HashMap;

/**
 * Class that represents the GiantCrab actor
 * @author Hayden Tran
 * @author Emily Jap
 * @version 1.0.0
 */
public class GiantCrab extends Crustacean implements RuneSource {
    /**
     * Constructor.
     *
     */
    public GiantCrab() {
        super("Giant Crab", 'C', 407);
        this.addCapability(Status.PERFORM_AREA_ATTACK);
        addRuneSource();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map){

        // these behaviours can occur when there are other actors in the surrounding area
        behaviours.put(998, new FollowBehaviour(otherActor));
        behaviours.put(2, new AttackBehaviour(getIntrinsicWeapon()));
        behaviours.put(3, new AreaAttackBehaviour(getIntrinsicWeapon()));

        ActionList actions= new ActionList();
        // actions the player or other enemy types can do to this actor
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && !otherActor.hasCapability(AttackType.CANNOT_ATTACK_CRUSTACEANS)){
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
            } else {
                actions.add(new AreaAttackAction(targets, otherActor.getIntrinsicWeapon()));
            }
        }

        return actions;
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(318, 4961));
        runeManager.addRuneSource(this);
    }
}
