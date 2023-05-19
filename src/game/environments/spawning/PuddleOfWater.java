package game.environments.spawning;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.crustacean.GiantCrab;
import game.actors.enemies.crustacean.GiantCrayfish;
import game.utils.RandomNumberGenerator;

/**
 * A class which represents the PuddleOfWater SpawningGround that spawns GiantCrabs and GiantCrayfish
 * @author Emily Jap
 * @version 1.0.0
 * @see SpawningGround
 */
public class PuddleOfWater extends SpawningGround {

    /**
     * Constructor that instantiates the ground and adds actors that can be added with their spawn chance
     */
    public PuddleOfWater() {
        super('~');
    }

    @Override
    public void spawnActor(EnemyFactory enemyFactory, Location location) {
        EnemyFactory east = new EastFactory();
        EnemyFactory west = new WestFactory();

        east.spawnCrustacean(location);
        west.spawnCrustacean(location);
    }
}
