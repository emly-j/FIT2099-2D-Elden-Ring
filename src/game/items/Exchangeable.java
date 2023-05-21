package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * An interface that will be implemented by items and objects that are exchangeable
 *
 * @author Hayden Tran
 * @version 1.0.0
 */
public interface Exchangeable {

    /**
     * Returns the exchangeable item as instance of an item class
     * @return exchangeable item as an item object
     */
    Item getExchangeableItem();

    /**
     * Removes the item from inventory once exchanged
     * @param actor actor we remove item from
     */
    void removeExchangeableFromInventory(Actor actor);

    /**
     * Gets a new exchange action for an exchangeable item
     * @return exchange action for the enchangeable item
     */
    ActionList getExchangeAction();
}
