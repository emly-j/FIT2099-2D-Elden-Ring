package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.controllers.ResetManager;
import game.controllers.RestLocationManager;
import game.environments.sitesoflostgrace.TheFirstStep;
import game.utils.Status;

/**
 * A class that represents the 'rest action' implemented when standing on The First Step
 *
 * @author Hayden Tran
 * @version 1.0.0
 * @see TheFirstStep
 * @see Action
 */
public class RestAction extends Action {

    private final Ground ground;
    private final Location location;
    private final String name;

    /**
     * Constructor.
     *
     * @param ground
     * @param location
     */
    public RestAction(Ground ground, Location location, String name) {
        this.ground = ground;
        this.location = location;
        this.name = name;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addCapability(Status.RESTED);
        RestLocationManager.storeLastLocation(this.location);
        ResetManager.getInstance().runReset(); //runs everything to be reset from resetmanager


        return "Game has been reset: " + actor + " has been moved to the " + this.name;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Rest at the " + this.name + " (reset game)";
    }


}
