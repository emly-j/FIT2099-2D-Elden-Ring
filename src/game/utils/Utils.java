package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.HashMap;
import java.util.List;

/**
 * A class that represents the static methods that can be accesed in other classes for clartiy
 * @author Emily Jap
 * @version 1.0.0
 */
public class Utils {
    public static HashMap<Actor, String> getSurroundingActors(Actor source, GameMap map) {
        HashMap<Actor, String> nearbyActors = new HashMap<>();

        List<Exit> exits = map.locationOf(source).getExits();
        for (Exit exit : exits){
            Actor nearbyActor = exit.getDestination().getActor();

            if (nearbyActor != null){
                String direction = exit.getName();
                nearbyActors.put(nearbyActor, direction);
            }
        }

        return nearbyActors;
    }

    public static boolean isTraderNearby(Location currentLocation){
        List<Exit> exits = currentLocation.getExits();
        boolean hasTrader = false;

        for (Exit exit: exits){
            if (exit.getDestination().getActor() != null){
                if (exit.getDestination().getActor().hasCapability(Status.IS_TRADER)){
                    hasTrader = true;
                }
            }
        }

        return hasTrader;
    }
}
