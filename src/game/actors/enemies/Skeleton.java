package game.actors.enemies;

import game.Status;
import game.actors.AttackType;
import game.behaviours.BecomePileOfBonesBehaviour;

public abstract class Skeleton extends Enemy{
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
        behaviours.put(1,new BecomePileOfBonesBehaviour());
    }

}
