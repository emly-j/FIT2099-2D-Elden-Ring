package game.actors.enemies.soldiers;

import game.actors.enemies.Enemy;

/**
 * Abstract class that represents the Soldier class of enemies
 *
 * @author Emily Jap
 * @version 1.0.0
 * @see Enemy
 */
public abstract class Soldier extends Enemy {
    /**
     * Constructor
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Soldier(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }
}
