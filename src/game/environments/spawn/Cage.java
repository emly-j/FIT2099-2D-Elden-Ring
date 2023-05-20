package game.environments.spawn;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Class that represents the spawning environment for dogs
 * @author Emily Jap
 * @version 1.0.0
 * @see SpawningGround
 */
public class Cage extends SpawningGround {
    /**
     * Constructor.
     */
    public Cage() {
        super('<');
    }

    @Override
    public void spawnActor(EnemyFactory enemyFactory, Location location) {
        EnemyFactory east = new EastFactory();
        EnemyFactory west = new WestFactory();

        east.spawnDog(location);
        west.spawnDog(location);
    }
}
