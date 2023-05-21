package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Exchangeable;
import game.items.RemembranceOfTheGrafted;
import game.items.weapons.AxeOfGodrick;
import game.items.weapons.GraftedDragon;

/**
 * Class that represents the action to exchange an item in exchange for 1 of 2 items in this implementation
 * @author Hayden Tran
 * @version 1.0.0
 *
 */
public class ExchangeAction extends Action {
    /**
     * The item that is exchanged
     */
    private final Exchangeable itemToExchange;
    /**
     * The item that is received after giving an item to exchange
     */
    private final Item itemToReceive;

    /**
     * Constructor to instantiate the items to exchange and receive
     * @param itemToExchange
     * @param itemToReceive
     */

    public ExchangeAction(Exchangeable itemToExchange, Item itemToReceive){
        this.itemToExchange = itemToExchange;
        this.itemToReceive = itemToReceive;
    }

    /**
     * Will remove item to exchange and adds an item toreceive based on user choice
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string of what is returned
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(itemToExchange.getExchangeableItem());
        itemToExchange.removeExchangeableFromInventory(actor);
        if (itemToReceive.toString() == "Axe of Godrick") {
            actor.addWeaponToInventory(new AxeOfGodrick());
        } else {
            actor.addWeaponToInventory(new GraftedDragon());
        }

        return itemToExchange + " was exchanged by " + actor + " for a " + itemToReceive;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " exchanges the " + itemToExchange + " for a " + itemToReceive;
    }
}
