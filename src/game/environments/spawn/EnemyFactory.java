package game.environments.spawn;

import edu.monash.fit2099.engine.positions.Location;

/**
 * An interface for spawning enemies in the game
 *
 * @author Emily Jap
 * @version 1.0.0
 */
public interface EnemyFactory {

    /**
     * A method for creating canine type enemies
     *
     * @param location location where the enemy will spawn
     */
    void spawnCanine(Location location);

    /**
     * A method for creating crustacean type enemies
     *
     * @param location location where the enemy will spawn
     */
    void spawnCrustacean(Location location);

    /**
     * A method for creating skeletal type enemies
     *
     * @param location location where the enemy will spawn
     */
    void spawnSkeleton(Location location);

    /**
     * A method for creating dragon type enemies
     *
     * @param location location where the enemy will spawn
     */
    void spawnDragon(Location location);

    /**
     * A method for creating Dog enemies
     *
     * @param location location where the enemy will spawn
     */
    void spawnDog(Location location);

    /**
     * A method for creating Soldier enemies
     *
     * @param location location where the enemy will spawn
     */
    void spawnSoldier(Location location);
}
