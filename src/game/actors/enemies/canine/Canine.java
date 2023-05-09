package game.actors.enemies.canine;

import game.actors.AttackType;
import game.actors.enemies.Enemy;

/**
 * Abstract class that will represent the base Canines (currently Lone Wolf and Giant Dog)
 * @author Emily Jap
 * @version 1.0.0
 * @see Enemy
 */
public abstract class Canine extends Enemy {
    /**
     * Constructor that instantiates the base canine with their capability of not being able to attack other canines
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Canine(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        addCapability(AttackType.CANNOT_ATTACK_CANINES);
    }
}
