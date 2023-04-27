package game.actors.enemies;

import game.actors.AttackType;

public abstract class Canine extends Enemy {
    /**
     * Constructor.
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
