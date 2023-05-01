package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.controllers.ResetManager;
import game.utils.Status;

/**
 * An class that represents the 'rest action' implemented when standing on The First Step
 * @see game.environments.TheFirstStep
 * @author Hayden Tran
 * @version 1.0.0
 */
public class RestAction extends Action {


    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addCapability(Status.RESTED);
        ResetManager.getInstance().runReset(); //runs everything to be reset from resetmanager
        System.out.println(actor.hasCapability(Status.RESTED));


        return "Game has been reset: " + actor + " has been moved to The First Step";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Rest at The First Step (reset game)";
    }
}
