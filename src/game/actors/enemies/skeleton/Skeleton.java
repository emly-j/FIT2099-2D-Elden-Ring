package game.actors.enemies.skeleton;

import game.actors.AttackType;
import game.actors.enemies.Enemy;
import game.behaviours.BecomePileOfBonesBehaviour;
import game.utils.Status;

/**
 * Abstract class that will hold the general behaviours of Skeletons
 *
 * @author Emily Jap
 * @version 1.0.0
 * @see Enemy
 */
public abstract class Skeleton extends Enemy {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Skeleton(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        addCapability(AttackType.CANNOT_ATTACK_SKELETONS);
        addCapability(Status.REVIVABLE);
        behaviours.put(1, new BecomePileOfBonesBehaviour());
    }

}
