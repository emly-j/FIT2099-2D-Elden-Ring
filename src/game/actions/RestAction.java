package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.controllers.ResetManager;
import game.controllers.Resettable;
import game.controllers.RestLocationManager;
import game.utils.Status;

/**
 * An class that represents the 'rest action' implemented when standing on The First Step
 * @see game.environments.TheFirstStep
 * @author Hayden Tran
 * @version 1.0.0
 */
public class RestAction extends Action {

    private Ground ground;
    private Location location;


    public RestAction(Ground ground, Location location){
        this.ground = ground;
        this.location = location;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addCapability(Status.RESTED);
        RestLocationManager.storeLastLocation(this.location);
        ResetManager.getInstance().runReset(); //runs everything to be reset from resetmanager


        return "Game has been reset: " + actor + " has been moved to The First Step";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Rest at The First Step (reset game)";
    }


}
