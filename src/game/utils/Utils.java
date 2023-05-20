package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import edu.monash.fit2099.engine.positions.NumberRange;
import java.util.HashMap;
import java.util.List;

/**
 * A class that represents the static methods that can be accessed in other classes for clarity
 * @author Emily Jap
 * @version 2.0.0
 */
public class Utils {

    /**
     * Returns a hashmap of actors within an actor's exits
     * @param source the actor possibly being surrounded by other actors
     * @param map the map of the game
     * @return a hashmap representing the surrounding actors and their position relative to the source actor
     */
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

    /**
     * Returns locations that are 2 blocks away from a source location
     * @param source the source location for which we are getting its ranged locations
     * @param map the game map
     * @return a hashmap representing each ranged location and their direction relative to the source location
     */
    public static HashMap<Location, String> getRangedLocations(Location source, GameMap map){
        HashMap<Location, String> result = new HashMap<>();
        int x = source.x();
        int y = source.y();

        addValidLocation(x,y - 2,"North", map, result);
        addValidLocation(x + 1, y - 2, "North-North-East", map, result);
        addValidLocation(x + 2, y - 2, "North-East", map, result);
        addValidLocation(x + 2, y - 1, "North-East-East", map, result);
        addValidLocation(x + 2, y, "East", map, result);
        addValidLocation(x + 2, y + 1, "South-East-East", map, result);
        addValidLocation(x + 2, y + 2, "South-East", map, result);
        addValidLocation(x + 1, y + 2, "South-South-East", map, result);
        addValidLocation(x, y + 2, "South", map, result);
        addValidLocation(x - 1, y + 2, "South-South-West", map, result);
        addValidLocation(x - 2, y + 2, "South-West", map, result);
        addValidLocation(x - 2, y + 1, "South-West-West", map, result);
        addValidLocation(x - 2, y, "West", map, result);
        addValidLocation(x - 2, y - 1, "North-West-West", map, result);
        addValidLocation(x - 2, y - 2, "North-West", map, result);
        addValidLocation(x - 1, y - 2, "North-North-West", map, result);

        return result;
    }

    /**
     * A method used to check if a location is within the boundaries of a map
     *
     * Used by getRangedLocations to add valid ranged locations
     * @param x X coordinate
     * @param y Y coordinate
     * @param name name of the ranged location relative to source
     * @param map the game map
     * @param result the hashmap we add valid locations to
     */
    private static void addValidLocation(int x, int y, String name, GameMap map, HashMap<Location, String> result){
        NumberRange widths = map.getXRange();
        NumberRange heights = map.getYRange();

        if(widths.contains(x) && heights.contains(y)){
            result.put(map.at(x,y), name);
        }
    }

    /**
     * Returns actors that are 2 blocks away from a source actor
     * @param source the actor possibly being surrounded by other actors
     * @param map the map of the game
     * @return a hashmap representing the ranged actors and their position relative to the source actor
     */
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

    /**
     * A method that checks if a trader is within the exits of a location
     * @param currentLocation the source location for which we are checking its exits
     * @return boolean
     */
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


    /**
     * A method that checks if a trader is within the exits of a location
     * @param currentLocation the source location for which we are checking its exits
     * @return boolean
     */
    public static boolean isExchangeTraderNearby(Location currentLocation){
        List<Exit> exits = currentLocation.getExits();
        boolean hasTrader = false;

        for (Exit exit: exits){
            if (exit.getDestination().getActor() != null){
                if (exit.getDestination().getActor().hasCapability(Status.ACCEPT_GODRICK_DROP)){
                    hasTrader = true;
                }
            }
        }

        return hasTrader;
    }
}
