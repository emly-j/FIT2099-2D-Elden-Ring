package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.HashMap;
import java.util.List;

/**
 * Class that represents the area attack action
 * @author Emily Jap
 * @version 1.0.0
 */
public class AreaAttackAction extends Action {
    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * A hashmap of actors to be attacked and their direction.
     */
    private HashMap<Actor,String> targets;

    /**
     * Constructor with intrinsic weapon as default.
     */
    public AreaAttackAction(HashMap<Actor,String> targets){
        this.targets = targets;
    }

    /**
     * Constructor.
     * @param weapon the weapon used to perform the attack
     */
    public AreaAttackAction(HashMap<Actor,String> targets, Weapon weapon) {
        this.targets = targets;
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " performs area attack \n";

        // get intrinsic weapon if possible
        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        // go through list of targets and create attack action for each
        for(Actor target: targets.keySet()){
            AttackAction attackAction = new AttackAction(target, targets.get(target), weapon);
            result += attackAction.execute(actor, map) + "\n";
        }

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " performs area attack with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }
}
