package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SellAction;
import game.items.Sellable;
import game.utils.Utils;

/**
 * A weapon that has no special attacks in this implementation
 * it deals 142 damage with an 84% hit rate
 *
 * @author Hayden Tran
 * @see WeaponItem
 * @see Sellable
 */
public class AxeOfGodrick extends WeaponItem implements Sellable {
    /**
     * SellAction for the AxeofGodrick
     */
    private Action sellAction;

    /**
     * Constructor that intantiates the item
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "axes", 84);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {

        // if there is a trader nearby, allow this item to be sold
        if (Utils.isTraderNearby(currentLocation) && (!getAllowableActions().contains(sellAction))) {
            sellAction = getSellAction();
            addAction(sellAction);
        } else if (!Utils.isTraderNearby(currentLocation) && (getAllowableActions().contains(sellAction))) {
            removeAction(sellAction);
        }
    }


    @Override
    public int getSellPrice() {
        return 100;
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
}
