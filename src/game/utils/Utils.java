package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.HashMap;
import java.util.List;

/**
 * A class that represents the static methods that can be accessed in other classes for clarity
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

    public static HashMap<Location, String> getRangedLocations(Location source, GameMap map){
        HashMap<Location, String> result = new HashMap<>();
        int x = source.x();
        int y = source.y();

        result.put(map.at(x,y - 1), "North");
        result.put(map.at(x + 1, y - 1), "North-East");
        result.put(map.at(x + 1, y), "East");
        result.put(map.at(x + 1, y + 1), "South-East");
        result.put(map.at(x, y + 1), "South");
        result.put(map.at(x - 1, y + 1), "South-West");
        result.put(map.at(x - 1, y), "West");
        result.put(map.at(x - 1, y - 1), "North-West");

        return result;
    }

    public static HashMap<Actor, String> getRangedActors(Actor source, GameMap map) {
        HashMap<Actor, String> result = new HashMap<>();
        Location actorLocation = map.locationOf(source);
        HashMap<Location, String> rangedLocations = getRangedLocations(actorLocation, map);

        for (Location location: rangedLocations.keySet()){
            if(location.containsAnActor()){
                result.put(location.getActor(), rangedLocations.get(location));
            }
        }

        return result;
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
