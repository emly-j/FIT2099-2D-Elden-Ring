package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.SellAction;

public interface Sellable {
    int getSellPrice();

    void sellItem(Actor actor);
}
