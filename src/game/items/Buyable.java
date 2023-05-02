package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public interface Buyable {
    int getBuyPrice();

    Action getBuyAction();

    Item getBuyableItem();

    void addBuyableToInventory(Actor actor);
}
