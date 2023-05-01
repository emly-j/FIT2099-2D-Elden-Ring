package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.BecomePileOfBonesAction;

/**
 * class that represents the become pile of bones behaviour used in Skeletons
 * @see game.actors.enemies.Skeleton
 * @author Emily Jap
 * @version 1.0.0
 */
public class BecomePileOfBonesBehaviour implements Behaviour {
    /**
     * Overwritting the getaction method that checks if the actor is alive, if not well return the pile of bones action
     * @see BecomePileOfBonesAction
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (!actor.isConscious()){
            return new BecomePileOfBonesAction(actor, map.locationOf(actor));
        }
        else {
            return null;
        }
    }
}
