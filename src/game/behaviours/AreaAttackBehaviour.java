package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Utils;
import game.actions.AreaAttackAction;

import java.util.HashMap;

public class AreaAttackBehaviour implements Behaviour {

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * Constructor with intrinsic weapon as default.
     */
    public AreaAttackBehaviour(){}

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
        if (nearbyActors == null){
            return null;
        }

        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        // TODO: Need to check that the weapon can perform an area attack?

        // return area attack action
        return new AreaAttackAction(nearbyActors);

    }
}