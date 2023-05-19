package game.environments.spawning;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.canine.GiantDog;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.canine.LoneWolf;
import game.utils.RandomNumberGenerator;

/**
 * Class that represents the GustofWind SpawningGround which can spawn the LoneWolf and GiantDog
 * @author Emily Jap
 * @version 1.0.0
 * @see SpawningGround
 */
public class GustOfWind extends SpawningGround {

    /**
     * Constructor that instantiates the ground and adds the actors which can spawn with their spawn chance
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

