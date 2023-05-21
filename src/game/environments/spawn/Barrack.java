package game.environments.spawn;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Class that represents the spawning environment for godrick soldiers
 *
 * @author Emily Jap
 * @version 1.0.0
 * @see SpawningGround
 */
public class Barrack extends SpawningGround {
    /**
     * Constructor.
     */
    public Barrack() {
        super('B');
    }

    @Override
    public void spawnActor(EnemyFactory enemyFactory, Location location) {
        EnemyFactory east = new EastFactory();
        EnemyFactory west = new WestFactory();

        east.spawnSoldier(location);
        west.spawnSoldier(location);
    }
}
