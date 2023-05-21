package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.DespawnAction;
import game.utils.RandomNumberGenerator;

/**
 * Class that that will return a new despawn action if the probablity is met
 *
 * @author Hayden Tran
 * @version 1.0.0
 */
public class DespawnBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {

        if (RandomNumberGenerator.getRandomChance(10)) {
            return new DespawnAction();
        }
        return null;
    }
}
