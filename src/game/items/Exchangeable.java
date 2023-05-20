package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public interface Exchangeable {

    /**
     * Returns the exchaneable item as instance of an item class
     * @return exchangeable item as an item object
     */
    Item getExchangeableItem();

    /**
     * Removes the item from inventory once exchanged
     * @param actor actor we remove item from
     */
    void removeExchangeableFromInventory(Actor actor);

    /**
     * gets a mew exchange action for an exchangeable item
     *
     * @return exchange action for the enchange item
     */
    ActionList getExchangeAction();
}
