package game.environments.spawning;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.dragons.LesserDragon;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class Dragonbarrow extends SpawningGround{

  /**
   * Constructor.
   */
  public Dragonbarrow() {
    super('r');
    this.addActorThatSpawns(new LesserDragon(), 10);
    addCapability(Status.FIRE_IMMUNE);
  }

  @Override
  public void spawnActor(Actor actor, Location location) {
    boolean canSpawn = RandomNumberGenerator.getRandomChance(getActorSpawnChance(actor));

    if(canSpawn){
      location.addActor(new LesserDragon());
    }
  }
}
