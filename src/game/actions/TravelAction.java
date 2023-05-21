package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class TravelAction extends Action {

    Location location;
    GameMap gameMap;
    String mapName;

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
