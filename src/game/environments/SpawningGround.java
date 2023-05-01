package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

import java.util.HashMap;

/**
 * A class that represents the abstract class SpawninGround, representing all ground that will spawn an actor
 * @author Emily Jap
 * @version 1.0.0
 */
public abstract class SpawningGround extends Ground {

    /**
     * A hashmap which will hold the actors that will spawn
     */
    private HashMap<Actor, Integer> actorsThatSpawn = new HashMap<Actor, Integer>();

    /**
     * Constructor.
     * @param displayChar
     */
    public SpawningGround(char displayChar) {
        super(displayChar);
    }

    /**
     * a method adds an actor that spawns into the hashmap with the .put() method
     * @param actor
     * @param actorSpawnChance
     */
    public void addActorThatSpawns(Actor actor, int actorSpawnChance){
        actorsThatSpawn.put(actor, actorSpawnChance);
    }

    /**
     * Updating the tick method that iterates over the actorsThatSpawn HashMap
     * and checks if a random probability is met and the location doesn't contain an actor,
     * spawn the actor at that location
     * @param location The location of the Ground
     */
    public void tick(Location location){
        for (Actor actor : actorsThatSpawn.keySet()){
            int actorSpawnChance = actorsThatSpawn.get(actor);
            if (RandomNumberGenerator.getRandomChance(actorSpawnChance) && !location.containsAnActor()){
                spawnActor(location);
            }
        }
    }

    /**
     * A factory method to spawn actors
     * @param location
     */
    public abstract void spawnActor(Location location);
}
