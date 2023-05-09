package game.environments.spawningenvironments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

import java.util.HashMap;

/**
 * A class that represents the abstract class SpawningGround, representing all ground that will spawn an actor.
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
     * Adds an actor that spawns from the SpawningGround
     * @param actor actor that spawns
     * @param actorSpawnChance the chance of the actor spawning from 0 to 100
     */
    public void addActorThatSpawns(Actor actor, int actorSpawnChance){
        actorsThatSpawn.put(actor, actorSpawnChance);
    }

    /**
     * Returns the hashmap of actors that spawn on the SpawningGround
     * @return hashmap of actors that spawn
     */
    public HashMap<Actor, Integer> getActorsThatSpawn(){
        return actorsThatSpawn;
    }

    /**
     * Returns the spawn chance of an actor
     * @param actor the actor we want to find the spawn chance of
     * @return an integer from 0 to 100 representing the spawn chance
     */
    public int getActorSpawnChance(Actor actor){
        return actorsThatSpawn.get(actor);
    }

    /**
     * Iterates over the actorsThatSpawn HashMap at each turn.
     * If the location doesn't contain an actor, then potentially spawn an actor at that location.
     * @param location The location of the SpawningGround
     */
    @Override
    public void tick(Location location){
        for (Actor actor : actorsThatSpawn.keySet()){
            if (!location.containsAnActor()){
                spawnActor(actor, location);
            }
        }
    }

    /**
     * A factory method to spawn actors depending on their chance of spawning and the location on the map.
     * @param actor actor that may potentially spawn
     * @param location location where the actor will spawn
     */
    public abstract void spawnActor(Actor actor, Location location);
}
