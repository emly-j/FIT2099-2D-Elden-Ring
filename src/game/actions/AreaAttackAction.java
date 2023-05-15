package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.utils.Utils;
import java.util.HashMap;

/**
 * An action to perform an area attack
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
    private Actor attacker;

    /**
     * Constructor with intrinsic weapon as default.
     */
    public AreaAttackAction(Actor attacker){
        this.attacker = attacker;
    }

    /**
     * Constructor.
     *
     * @param attacker the actor performing the area attack
     * @param weapon   the weapon used to perform the attack
     */
    public AreaAttackAction(Actor attacker, Weapon weapon) {
        this.attacker = attacker;
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = attacker + " performs area attack \n";

        // get intrinsic weapon if possible
        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        // go through list of targets and create attack action for each
        HashMap<Actor, String> targets = Utils.getSurroundingActors(attacker, map);

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
