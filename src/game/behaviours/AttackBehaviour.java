package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actors.AttackType;
import game.utils.RandomNumberGenerator;

import java.util.List;


/**
 * Class that represents the attackbehaviour used by NPCS
 *
 * @author Emily Jap
 * @version 1.0.0
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * Constructor with intrinsic weapon as default.
     */
    public AttackBehaviour() {
    }

    /**
     * Constructor with specified weapon.
     */
    public AttackBehaviour(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        List<AttackType> attackTypes = actor.findCapabilitiesByType(AttackType.class);

        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        // 50% chance of using weapon skill
        if (RandomNumberGenerator.getRandomChance(50)) {
            Action skillAction = weapon.getSkill(actor);
            if (skillAction != null) {
                return skillAction;
            }
        }

        // check if target is nearby
        List<Exit> exits = map.locationOf(actor).getExits();
        for (Exit exit : exits) {
            Actor target = exit.getDestination().getActor();

            // actor cannot attack another actor of the same type
            if (target != null) {
                List<AttackType> nearbyActorTypes = target.findCapabilitiesByType(AttackType.class);
                for (AttackType attackType : attackTypes) {
                    if (nearbyActorTypes.contains(attackType)) {
                        return null;
                    }
                }

                // initiate attack if there is a valid target nearby
                String direction = exit.getName();
                return new AttackAction(target, direction, weapon);
            }

        }

        return null;
    }
}
