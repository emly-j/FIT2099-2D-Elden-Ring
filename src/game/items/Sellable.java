package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
//import game.actions.SellAction;

/**
 * @author Hayden Tran
 * @version 1.0.0
 */
public interface Sellable {
    int getSellPrice();

    Action getSellAction();
}
