package game.items.consumable;


import edu.monash.fit2099.engine.items.Item;
import game.Resettable;
import game.actions.ConsumeFlaskOfCrimsonTearsAction;

/**
 * An item that has a consume method which will heal 250 HP
 * cannot be dropped and has 2 uses
 */
public class FlaskOfCrimsonTears extends Item implements Resettable {

    private int charges;
    private final int MAX_USES = 2;

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public FlaskOfCrimsonTears(String name, char displayChar, boolean portable) {
        super("Flask Of Crimson Tears", 'c', false);
        this.addAction(new ConsumeFlaskOfCrimsonTearsAction(this)); //makes an action which takes this in as a parameter to use
    }

    public int decrementCharges() {
        return this.charges -= 1;
    }
    public int getCharges() {
        return charges;
    }
    @Override
    public void reset() {
        this.charges = MAX_USES;
    }
}

