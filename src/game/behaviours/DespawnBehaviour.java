package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.RandomNumberGenerator;
import game.actions.DespawnAction;

import java.util.Random;

/**
 * Class the represents the despawn behaviour in npcs
 * @author Hayden Tran
 * @author Emily Jap
 * @version 1.0.0
 */
public class DespawnBehaviour implements Behaviour{

    /**
     * Overwritting the getaction that gets a uses the getRandomChance method, checks if 1/10 is rolled, then returns a new Despawn action
     * otherwise no action returned
     * @see DespawnAction
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        if (RandomNumberGenerator.getRandomChance(10)){
            return new DespawnAction();
        }
        return null;
    }
}
