package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SellAction;
import game.items.Sellable;
import game.items.Tradeable;

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
        this.addCapability(Tradeable.SELLABLE);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return null;
    }

    @Override
    public int getSellPrice() {
        return 100;
    }

    @Override
    public void sellItem(Actor actor) {

    }
}
