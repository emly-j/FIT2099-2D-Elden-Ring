package game.environments.spawning;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.canine.Dog;
import game.utils.RandomNumberGenerator;

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
