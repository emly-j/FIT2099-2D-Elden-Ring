package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ExchangeAction;
import game.actions.SellAction;
import game.items.weapons.AxeOfGodrick;
import game.items.weapons.GraftedDragon;
import game.utils.Utils;

public class RemembranceOfTheGrafted extends Item implements Exchangeable, Sellable {
    /***
     * Constructor.
     */

    private Action axeExchange;
    private Action graftExchange;
    private Action sellAction;

    public RemembranceOfTheGrafted() {
        super("Remembrance of the Grafted", 'O', true);
    }


    @Override
    public void tick(Location currentLocation, Actor actor) {

        if (Utils.isTraderNearby(currentLocation) && (!getAllowableActions().contains(sellAction))) {
            sellAction = getSellAction();
            addAction(sellAction);
            System.out.println("ACTION ADDED");
            if (Utils.isExchangeTraderNearby(currentLocation) && (!getAllowableActions().contains(axeExchange))) {
//            sellAction = getSellAction();
                axeExchange = getExchangeAction().get(0);
                graftExchange = getExchangeAction().get(1);
                addAction(axeExchange);
                addAction(graftExchange);
//            addAction(sellAction);
            }
        } else if (!Utils.isTraderNearby(currentLocation) && (getAllowableActions().contains(sellAction))) {
            System.out.println("this work");
            removeAction(sellAction);
            if (!Utils.isExchangeTraderNearby(currentLocation) && (getAllowableActions().contains(axeExchange))) {
                removeAction(graftExchange);
                removeAction(axeExchange);
            }
        }
    }


    @Override
    public Item getExchangeableItem() {
        return this;
    }

    @Override
    public void removeExchangeableFromInventory(Actor actor) {
        actor.removeItemFromInventory(this);
    }

    @Override
    public ActionList getExchangeAction() {
        ActionList exchangeActions = new ActionList();
        exchangeActions.add(new ExchangeAction(this, new AxeOfGodrick()));
        exchangeActions.add(new ExchangeAction(this, new GraftedDragon()));
        return exchangeActions;
    }

    @Override
    public int getSellPrice() {
        return 20000;
    }

    @Override
    public Action getSellAction() {
        return new SellAction(this);
    }

    @Override
    public Item getSellableItem() {
        return this;
    }

    @Override
    public void removeSellableFromInventory(Actor actor) {
        actor.removeItemFromInventory(this);
    }
}
