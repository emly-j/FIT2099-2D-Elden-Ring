package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;

public class RestAction extends Action {


    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run(); //runs everything to be reset from resetmanager
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Game Reset.";
    }
}

