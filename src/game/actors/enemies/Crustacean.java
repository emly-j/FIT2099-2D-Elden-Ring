package game.actors.enemies;

import game.actors.Type;

public abstract class Crustacean extends Enemy {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Crustacean(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        addCapability(Type.IS_CRUSTACEAN);
    }
}
