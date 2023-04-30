package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.DespawnAction;

import java.util.Random;

public class DespawnBehaviour implements Behaviour{


    @Override
    public Action getAction(Actor actor, GameMap map) {

        Random random = new Random();
        int tenPercent = random.nextInt(9);
        System.out.println("TENPERECENT" + tenPercent);
        if (tenPercent == 1){
            return new DespawnAction();
        }
        return null;
    }
}
