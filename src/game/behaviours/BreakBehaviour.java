package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Breakable;

import java.util.List;

public class BreakBehaviour implements Behaviour{
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // if actor is near a breakable, return break action, else null
        List<Exit> actorExits = map.locationOf(actor).getExits();

        // TODO: CONSIDER MAKING ITEMSNEARACTOR A UTIL METHOD
        for (Exit exit: actorExits){
            Location exitLocation = exit.getDestination();
            List<Item> itemsAtLocation = exitLocation.getItems();

            for (Item item : itemsAtLocation){
                if (item instanceof Breakable){
                    return ((Breakable) item).getBreakAction();
                }
            }

        }
        return null;
    }
}
