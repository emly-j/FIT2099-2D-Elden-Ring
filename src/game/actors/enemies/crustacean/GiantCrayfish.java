package game.actors.enemies.crustacean;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actors.AttackType;
import game.actors.enemies.crustacean.Crustacean;
import game.behaviours.AreaAttackBehaviour;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.utils.RandomNumberGenerator;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.Status;
import game.utils.Utils;
import java.util.HashMap;

/**
 * Class that represents the GiantCrayfish actor
 * @author Hayden Tran
 * @author Emily Jap
 * @version 1.0.0
 */

public class GiantCrayfish extends Crustacean implements RuneSource {
    /**
     * Constructor that instantiates the actor
     */
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803);
        this.addCapability(Status.PERFORM_AREA_ATTACK);
        addRuneSource();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map){

        // these behaviours can occur when there are other actors in the surrounding area
        behaviours.put(600, new FollowBehaviour(otherActor));
        behaviours.put(2, new AttackBehaviour());
        behaviours.put(3, new AreaAttackBehaviour());

        ActionList actions= new ActionList();
        // actions the player or other enemy types can do to this actor
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && !otherActor.hasCapability(
            AttackType.CANNOT_ATTACK_CRUSTACEANS)){
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

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "pincer slams", 100);
    }

    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(500, 2374));
        runeManager.addRuneSource(this);
    }
}