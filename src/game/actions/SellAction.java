package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.controllers.RuneManager;
import game.items.Sellable;

/**
 * Class that represents the action to sell an item
 * @author Emily Jap
 * @version 1.0.0
 */

public class SellAction extends Action {

    private Sellable itemToSell;

    /**
     * sets item to sell to this particular instance
     * @param itemToSell
     */

    public SellAction(Sellable itemToSell) {
        this.itemToSell = itemToSell;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // remove item from actor's inventory
        Item item = itemToSell.getSellableItem();
        itemToSell.removeSellableFromInventory(actor);

        // add runes to actor
        int runes = itemToSell.getSellPrice();
        RuneManager.getInstance().addRunes(actor, runes);

        return itemToSell + " was sold by " + actor;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + itemToSell;
    }
}
