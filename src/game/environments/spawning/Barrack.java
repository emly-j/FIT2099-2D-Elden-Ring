package game.environments.spawning;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.soldiers.GodrickSoldier;
import game.utils.RandomNumberGenerator;

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
