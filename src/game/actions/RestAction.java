package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;
import game.Status;

public class RestAction extends Action {


    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addCapability(Status.RESTED);
        ResetManager.getInstance().runReset(); //runs everything to be reset from resetmanager
        System.out.println(actor.hasCapability(Status.RESTED));


        return "Game has been reset: actor is moved to The First Step";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Rest at The First Step (reset game)";
    }
}
