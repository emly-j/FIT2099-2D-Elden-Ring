package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.controllers.RuneManager;
import game.items.Sellable;

public class SellAction extends Action {

    private Sellable itemToSell;

    public SellAction(Sellable itemToSell) {
        this.itemToSell = itemToSell;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // remove item from actor's inventory
        Item item = itemToSell.getItem();
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
