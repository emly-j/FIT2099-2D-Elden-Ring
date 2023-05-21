package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.controllers.RuneManager;
import game.items.Buyable;

/**
 * An action to allow actors to buy items that are buyable
 *
 * @author Emily Jap
 * @see Action
 */
public class BuyAction extends Action {

    /**
     * The item that is to be bought
     */
    private final Buyable itemToBuy;

    /**
     * Constructor.
     *
     * @param itemToBuy The item that is to be bought
     */
    public BuyAction(Buyable itemToBuy) {
        this.itemToBuy = itemToBuy;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // check that player has enough runes
        int buyPrice = itemToBuy.getBuyPrice();
        RuneManager runeManager = RuneManager.getInstance();

        if (runeManager.getRunes(actor) >= buyPrice) {
            runeManager.subtractRunes(actor, buyPrice);

            // add item to actor's inventory
            itemToBuy.addBuyableToInventory(actor);

            return itemToBuy + " was bought by " + actor;

        }

        return actor + " did not have enough runes ";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + itemToBuy + " for " + itemToBuy.getBuyPrice() + " runes";
    }
}
