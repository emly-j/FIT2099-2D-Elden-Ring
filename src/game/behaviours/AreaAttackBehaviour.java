package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AreaAttackAction;
import game.utils.RandomNumberGenerator;
import game.utils.Utils;

import java.util.HashMap;

/**
 * Class the represents the area attack behaviour used by certain enemies
 *
 * @author Emily Jap
 * @version 1.0.0
 */
public class AreaAttackBehaviour implements Behaviour {

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * Constructor with intrinsic weapon as default.
     */
    public AreaAttackBehaviour() {
    }

    /**
     * Constructor with specified weapon.
     */
    public AreaAttackBehaviour(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        HashMap<Actor, String> nearbyActors = Utils.getSurroundingActors(actor, map); // holds list of nearby actors

        // find nearby actors
        if (nearbyActors == null) {
            return null;
        }

        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        // 50% chance of using area attack skill
        if (RandomNumberGenerator.getRandomChance(50)) {
            return new AreaAttackAction(weapon);
        }

        return null;

    }
}
