package game.environments.damage;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.environments.Dirt;
import game.environments.damage.DamageGround;
import game.utils.Status;

/**
 * A ground that is on fire.
 * @author Emily Jap
 * @version 1.0.0
 */
public class FireGround extends DamageGround {

  int counter;

  /**
   * Constructor.
   */
  public FireGround() {
    super('F', 100);
    int counter = 0;
  }

  @Override
  public void tick(Location location){

    // set ground to dirt after 3 turns
    if (counter == 3){
      location.setGround(new Dirt());
    }

    // if there is an actor on this ground, deal damage, unless they're fire immune
    if (location.containsAnActor()){
      Actor actor = location.getActor();

      if (!actor.hasCapability(Status.FIRE_IMMUNE)){
        actor.hurt(getDamage());
      }
    }

    counter += 1;
  }
}
