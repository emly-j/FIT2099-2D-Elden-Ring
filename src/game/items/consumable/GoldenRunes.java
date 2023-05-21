package game.items.consumable;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeRuneAction;
import game.items.Consumable;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents the Item that is consumable and will give a certain amount of runes when consumed
 *
 * @author Hayden Tran
 * @version 1.0.0
 * @see Item
 * @see Consumable
 */
public class GoldenRunes extends Item implements Consumable {
    /**
     * Amount of charges that the item holds
     */
    private int charges;
    /**
     * The amount of runes that the rune gives when consumed
     */
    private final int value;

    /**
     * Constructor which instantiates the item with the amount of runes it holds and charges
     */
    public GoldenRunes() {
        super("Golden Rune", '*', true);
        this.value = RandomNumberGenerator.getRandomInt(200, 10000);
        this.charges = 1;
    }

    /**
     * Updated tick method so that whenever we are holding the item, we have the option to ConsumeRuneAction
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (this.charges == 0) {
            actor.removeItemFromInventory(this);
        }
        if (actor.getItemInventory().contains(this)) {
            this.addAction(new ConsumeRuneAction(this, value));
        }
    }

    @Override
    public int getCharges() {
        return this.charges;
    }

    @Override
    public void reduceCharges() {
        this.charges -= 1;
    }

    @Override
    public String chargesString() {
        return null;
    }

}
