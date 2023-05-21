package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that will perform the action of moving a player to a different map when stepping on a GoldenFogDoor
 *
 * @author Hayden Tran
 * @version 1.0.0
 * @see Action
 */
public class TravelAction extends Action {
    /**
     * The stored location that the user will teleport to
     */
    private final Location location;
    /**
     * The map that the user will teleport to
     */
    private final GameMap gameMap;
    /**
     * A string of the map name so that we use it in the menuDescription string
     */
    private final String mapName;

    /**
     * A Constructor to instantiate all the parameters for this specific TravelAction
     *
     * @param location
     * @param gameMap
     * @param mapName
     */
    public TravelAction(Location location, GameMap gameMap, String mapName) {
        this.location = location;
        this.gameMap = gameMap;
        this.mapName = mapName;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, location);
        return actor + " has moved to " + this.mapName;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + this.mapName;
    }
}
