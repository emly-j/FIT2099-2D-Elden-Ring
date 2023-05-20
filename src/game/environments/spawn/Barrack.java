package game.environments.spawn;

import edu.monash.fit2099.engine.positions.Location;

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
