package game.environments.spawn;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Class that represents the Graveyard SpawningGround which can spawn the HeavySkeletalSwordsman and SkeletalBandit
 *
 * @author Emily Jap
 * @version 2.0.0
 * @see SpawningGround
 */
public class Graveyard extends SpawningGround {

    /**
     * Constructor.
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

