package game.environments.spawningenvironments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.canine.Dog;
import game.actors.enemies.dragons.LesserDragon;
import game.utils.RandomNumberGenerator;

public class Dragonbarrow extends SpawningGround{

  /**
   * Constructor.
   */
  public Dragonbarrow() {
    super('B');
    this.addActorThatSpawns(new LesserDragon(), 37);
  }

  @Override
  public void spawnActor(Actor actor, Location location) {
    boolean canSpawn = RandomNumberGenerator.getRandomChance(getActorSpawnChance(actor));

    if(canSpawn){
      location.addActor(actor);
    }
  }
}
