package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Class that represents removal of actors when called
 * @author Hayden Tran
 * @version 1.0.0
 * @see Action
 */
public class RemoveAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return actor + " has been removed from the map.";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
