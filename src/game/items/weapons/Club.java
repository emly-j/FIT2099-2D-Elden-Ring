package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SellAction;
import game.items.Sellable;
//import game.actions.SellAction;

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
        // if there is, add getSellAction to allowableActions
        // else, remove sellAction from allowable actions
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
