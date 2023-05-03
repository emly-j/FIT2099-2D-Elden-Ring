package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * An interface for objects that are sellable
 * @author Emily Jap
 * @version 1.0.0
 */
public interface Sellable {

    /**
     * Gets the amount of runes an actor can receive by selling the Sellable
     * @return integer representing the sell price
     */
    int getSellPrice();

    /**
     * Gets new SellAction instance for the Sellable
     * @return sell action for the Sellable
     */
    Action getSellAction();

    /**
     * Returns the sellable item as an instance of the Item class
     * @return sellable as an Item object
     */
    Item getSellableItem();

    /**
     * Removes sellable from an actor's weapon inventory or item inventory (depending on implementation).
     * @param actor actor which we want to remove the sellable from
     */
    void removeSellableFromInventory(Actor actor);
}
