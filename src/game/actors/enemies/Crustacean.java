package game.actors.enemies;

import game.actors.AttackType;


/**
 * Abstract class represent the base crustacean actors
 * @author Emily Jap
 * @version 1.0.0
 * @see Enemy
 */
public abstract class Crustacean extends Enemy {
    /**
     * Constructor that instantiates that Crustaceans cannot attack other crustaceans
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Crustacean(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        addCapability(AttackType.CANNOT_ATTACK_CRUSTACEANS);
    }
}
