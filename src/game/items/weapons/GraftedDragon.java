package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.ExchangeAction;
import game.actions.SellAction;
import game.items.Exchangeable;
import game.items.RemembranceOfTheGrafted;
import game.items.Sellable;
import game.utils.Utils;

public class GraftedDragon extends WeaponItem implements Sellable {
    /**
     * Constructor.
     */

    private Action sellAction;
    private Action exchangeAction;
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "vrooms", 90);
    }

    @Override
    public void tick(Location currentLocation, Actor actor){
        // if there is a trader nearby, allow this item to be sold
        if (Utils.isTraderNearby(currentLocation) && (!getAllowableActions().contains(sellAction))){
            sellAction = getSellAction();
            addAction(sellAction);
        }

        else if (!Utils.isTraderNearby(currentLocation) && (getAllowableActions().contains(sellAction))){
            removeAction(sellAction);
        }
    }

    @Override
    public int getSellPrice() {
        return 200;
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
        actor.removeWeaponFromInventory(this);
    }

//    @Override
//    public Item getExchangeableItem() {
//        return this;
//    }
//
//    @Override
//    public void removeExchangeableFromInventory(Actor actor) {
//        actor.removeWeaponFromInventory(this);
//    }

//    @Override
//    public Action getExchangeAction() {
//        return new ExchangeAction(this);
//    }
}
