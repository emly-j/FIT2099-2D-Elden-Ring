package game.environments.spawning;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that represents the abstract class SpawningGround, representing all ground that will spawn an actor.
 * @author Emily Jap
 * @version 1.0.0
 */
public abstract class SpawningGround extends Ground {

    /**
     * A factory interface for spawning enemies
     */
    private EnemyFactory enemyFactory;

    /**
     * Constructor.
     * @param displayChar
     */
    public SpawningGround(char displayChar) {
        super(displayChar);
    }

    /**
     * Iterates over the actorsThatSpawn HashMap at each turn.
     * If the location doesn't contain an actor, then potentially spawn an actor at that location.
     * @param location The location of the SpawningGround
     */
    @Override
    public void tick(Location location){
        if (!location.containsAnActor()){
            spawnActor(enemyFactory, location);
        }
    }

    /**
     * A factory method to spawn actors depending the type of spawning ground and the location on the map.
     * @param enemyFactory the abstract factory enemyFactory that spawns enemies
     * @param location location where the actor will spawn
     */
    public abstract void spawnActor(EnemyFactory enemyFactory, Location location);
}
