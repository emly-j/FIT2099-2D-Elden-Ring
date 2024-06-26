package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;


/**
 * Class that represents the Despawn action which removes the actor from that map when executed
 *
 * @author Hayden Tran
 * @version 1.0.0
 * @see Action
 */
public class DespawnAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return actor + " has despawned";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
