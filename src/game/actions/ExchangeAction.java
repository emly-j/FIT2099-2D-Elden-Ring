package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Exchangeable;
import game.items.weapons.AxeOfGodrick;
import game.items.weapons.GraftedDragon;

public class ExchangeAction extends Action {
    private final Exchangeable itemToExchange;
    private final Item itemToReceive;

    public ExchangeAction(Exchangeable itemToExchange, Item itemToReceive) {
        this.itemToExchange = itemToExchange;
        this.itemToReceive = itemToReceive;
    }

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
