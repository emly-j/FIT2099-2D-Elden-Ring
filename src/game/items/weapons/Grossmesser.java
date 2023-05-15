package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.utils.Status;
import game.actions.SellAction;
import game.items.Sellable;
import game.utils.Utils;

/**
 * A weapon carried by HeavySkeletalSwordsman.
 * @author Emily
 * @version 1.0
 * @see WeaponItem
 * @see Sellable
 */
public class Grossmesser extends WeaponItem implements Sellable {

    /**
     * SellAction for the Grossmesser. Ensures there is one instance of SellAction at a time.
     */
    private Action sellAction;

    /**
     * Constructor.
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "slashes", 85);
        this.addCapability(Status.PERFORM_AREA_ATTACK);
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
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction();
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
