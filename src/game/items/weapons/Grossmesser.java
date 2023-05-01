package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;
import game.actions.AttackAction;
//import game.actions.SellAction;
import game.actions.SellAction;
import game.items.Sellable;
//import game.items.Tradeable;

/**
 * A weapon carried by HeavySkeletalSwordsman.
 *
 * @author Emily
 * @version 1.0
 * @see WeaponItem
 */
public class Grossmesser extends WeaponItem implements Sellable {
    /**
     * Constructor.
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "slashes", 85);
        //this.addCapability(Tradeable.SELLABLE);
        this.addCapability(Status.PERFORM_AREA_ATTACK);
    }

    @Override
    public void tick(Location currentLocation, Actor actor){
        // check if there is a trader nearby
        // if there is, add getSellAction to allowableActions
        // else, remove sellAction from allowable actions
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new AttackAction(target, direction);
    }

    @Override
    public int getSellPrice() {
        return 100;
    }

    @Override
    public Action getSellAction() {
        return new SellAction(this);
    }

}
