package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TravelAction;
import game.utils.Status;

/**
 * A class that represents the floor that adds a travelAction when next to for the player
 *
 * @author Hayden Tran
 * @version 1.0.0
 */
public class GoldenFogDoor extends Ground {

    /**
     * The location that we wish to teleport to
     */
    private final Location teleportLocation;
    /**
     * The map of the location we wish to teleport to
     */
    private final GameMap gameMap;
    /**
     * The mapname in string format so we can use in menudescription
     */
    private final String mapName;

    /**
     * Constructor to instantiate the ground with its parameters
     */
    public GoldenFogDoor(Location teleportLocation, GameMap gameMap, String mapName) {
        super('D');
        this.teleportLocation = teleportLocation;
        this.gameMap = gameMap;
        this.mapName = mapName;
    }

    /**
     * A boolean to check whether a PLAYER can enter or not
     *
     * @param actor the Actor to check
     * @return true if has Status.HOSTILE_TO_ENEMY (player checker)
     */
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    /**
     * The updates ActionList for the actor when they enter this ground
     *
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return any actions added (Rest Action if possible)
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new TravelAction(this.teleportLocation, this.gameMap, this.mapName));
        }
        return actions;
    }
}
