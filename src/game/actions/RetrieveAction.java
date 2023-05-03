package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * abstract class that represents all items that may be retrieved
 * @author Hayden Tran
 * @version 1.0.0
 * @see Action
 */
public abstract class RetrieveAction extends Action {

    private final Item item;

    /**
     * Constructor that has item as an input and sets it
     * @param item
     */
    public RetrieveAction(Item item){
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).removeItem(item);
        return menuDescription(actor) + "retrieve action execute";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " retrieves the " + item;
    }
}
