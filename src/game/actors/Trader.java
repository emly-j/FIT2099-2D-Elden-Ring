package game.actors;
import edu.monash.fit2099.engine.actors.Actor;
import game.utils.Status;

/**
 * An abstract class which will have the base capabilities of all future Traders
 * @author Emily Jap
 * @version 1.0.0
 */
public abstract class Trader extends Actor {

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Trader(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        addCapability(Status.IS_TRADER);
    }


}
