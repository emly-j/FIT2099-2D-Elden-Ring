package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.BecomePileOfBonesAction;

/**
 * class that represents the become pile of bones behaviour used in Skeletons
 *
 * @author Emily Jap
 * @version 1.0.0
 * @see game.actors.enemies.skeleton
 */
public class BecomePileOfBonesBehaviour implements Behaviour {
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (!actor.isConscious()) {
            return new BecomePileOfBonesAction(actor, map.locationOf(actor));
        } else {
            return null;
        }
    }
}
