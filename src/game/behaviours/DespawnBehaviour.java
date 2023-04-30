package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.RandomNumberGenerator;
import game.actions.DespawnAction;

import java.util.Random;

public class DespawnBehaviour implements Behaviour{


    @Override
    public Action getAction(Actor actor, GameMap map) {

        if (RandomNumberGenerator.getRandomChance(10)){
            return new DespawnAction();
        }
        return null;
    }
}
