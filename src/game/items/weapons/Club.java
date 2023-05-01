package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SellAction;
import game.actors.Trader;
import game.items.Sellable;
import game.utils.Status;

import java.util.List;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Club extends WeaponItem implements Sellable {

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    @Override
    public void tick(Location currentLocation, Actor actor){

        // check if there is a trader nearby
        // TODO: consider making this a util method
        List<Exit> exits = currentLocation.getExits();
        boolean hasTrader = false;

        for (Exit exit: exits){
            if (exit.getDestination().getActor() != null){
                if (exit.getDestination().getActor().hasCapability(Status.IS_TRADER)){
                    hasTrader = true;
                }
            }
        }

        // if there is, add getSellAction to allowableActions
        // else, remove sellAction from allowable actions
        if (hasTrader == true){
            addAction(getSellAction());
        }
        else{
            removeAction(getSellAction());
        }
    }

    public int getSellPrice() {
        return 100;
    }

    public Action getSellAction() {
        return new SellAction(this);
    }

    public Item getItem() {
        return this;
    }

    public void removeSellableFromInventory(Actor actor) {
        actor.removeWeaponFromInventory(this);
    }


}
