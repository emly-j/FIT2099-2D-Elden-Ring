package game.environments.spawning;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Class that represents the Graveyard SpawningGround which can spawn the HeavySkeletalSwordsman and SkeletalBandit
 * @author Emily Jap
 * @version 1.0.0
 * @see SpawningGround
 */
public class Graveyard extends SpawningGround {

    /**
     * Constructor that instantiates the ground and adds actors that can be added with their spawn chance.
     */
    public Graveyard() {
        super('n');
    }

    @Override
    public void spawnActor(EnemyFactory enemyFactory, Location location) {
        EnemyFactory east = new EastFactory();
        EnemyFactory west = new WestFactory();

        east.spawnSkeleton(location);
        west.spawnSkeleton(location);
    }
}

