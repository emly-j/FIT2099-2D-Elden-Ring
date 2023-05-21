package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * An interface for objects that are buyable
 *
 * @author Emily Jap
 * @version 1.0.0
 */
public interface Buyable {

    /**
     * Gets the amount of runes an actor must have to buy the buyable
     *
     * @return integer representing the buy price
     */
    int getBuyPrice();

    /**
     * Gets new BuyAction instance for the Buyable
     *
     * @return buy action for the Buyable
     */
    Action getBuyAction();

    /**
     * Returns the buyable item as an instance of the Item class
     *
     * @return buyable as an Item object
     */
    Item getBuyableItem();

    /**
     * Adds buyable to an actor's weapon inventory or item inventory (depending on implementation).
     *
     * @param actor actor which we want to add the buyable to
     */
    void addBuyableToInventory(Actor actor);
}
