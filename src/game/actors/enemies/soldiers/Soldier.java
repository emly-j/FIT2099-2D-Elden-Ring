package game.actors.enemies.soldiers;

import game.actors.enemies.Enemy;

public abstract class Soldier extends Enemy {
    /**
     * Constructor that instantiates the base Enemy behaviours and being a resettable instance
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Soldier(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }
}
