package game.environments.spawn;

import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;

public class Dragonbarrow extends SpawningGround{

  /**
   * Constructor.
   */
  public Dragonbarrow() {
    super('r');
    addCapability(Status.FIRE_IMMUNE);
  }

  @Override
  public void spawnActor(EnemyFactory enemyFactory, Location location) {
    EnemyFactory east = new EastFactory();
    EnemyFactory west = new WestFactory();

    east.spawnDragon(location);
    west.spawnDragon(location);
  }
}
