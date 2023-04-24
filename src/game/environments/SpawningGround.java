package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class SpawningGround extends Ground {

    private HashMap<Actor, Integer> actorsThatSpawn = new HashMap<Actor, Integer>();

    /**
     * Constructor.
     * @param displayChar
     */
    public SpawningGround(char displayChar) {
        super(displayChar);
    }

    public void addActorThatSpawns(Actor actor, int actorSpawnChance){
        actorsThatSpawn.put(actor, actorSpawnChance);
    }

    public void tick(Location location){
        for (Actor actor : actorsThatSpawn.keySet()){
            if (RandomNumberGenerator.getRandomChance(actorsThatSpawn.get(actor)) && !location.containsAnActor()){
                spawnActor(location);
            }
        }
    }

    // A factory method to spawn actors
    public abstract void spawnActor(Location location);
}
