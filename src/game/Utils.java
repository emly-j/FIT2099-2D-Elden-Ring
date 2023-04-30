package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.HashMap;
import java.util.List;

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
}
