package game.environments.spawn;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Class that represents the GustofWind SpawningGround which can spawn the LoneWolf and GiantDog
 * @author Emily Jap
 * @version 2.0.0
 * @see SpawningGround
 */
public class GustOfWind extends SpawningGround {

    /**
     * Constructor
     */
    public GustOfWind() {
        super('&');
    }

    @Override
    public void spawnActor(EnemyFactory enemyFactory, Location location) {
        EnemyFactory east = new EastFactory();
        EnemyFactory west = new WestFactory();

        east.spawnCanine(location);
        west.spawnCanine(location);
    }
}

