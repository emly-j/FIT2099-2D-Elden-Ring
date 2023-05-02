package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.BuyAction;
import game.actions.SellAction;
import game.actors.Trader;
import game.items.Buyable;
import game.items.Sellable;
import game.utils.Status;
import game.utils.Utils;

import java.util.List;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Club extends WeaponItem implements Sellable, Buyable {

    private Action sellAction; // ensures there is one instance of SellAction at a time

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
        sellAction = null;
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

    public int getSellPrice() {
        return 100;
    }

    public Action getSellAction() {
        return new SellAction(this);
    }

    public Item getSellableItem() {
        return this;
    }

    public void removeSellableFromInventory(Actor actor) {
        actor.removeWeaponFromInventory(this);
    }


    @Override
    public int getBuyPrice() {
        return 600;
    }

    @Override
    public Action getBuyAction() {
        return new BuyAction(this);
    }

    @Override
    public Item getBuyableItem() {
        return this;
    }

    @Override
    public void addBuyableToInventory(Actor actor) {
        actor.addWeaponToInventory(this);
    }
}
