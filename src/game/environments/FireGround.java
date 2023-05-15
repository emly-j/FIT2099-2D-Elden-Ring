package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;

public class FireGround extends DamageGround{

  /**
   * Constructor.
   */
  public FireGround() {
    super('F', 100);
  }

  @Override
  public void tick(Location location){
    // if there is an actor on this ground, deal damage, unless they're a fire type
    if (location.containsAnActor()){
      Actor actor = location.getActor();

      if (!actor.hasCapability(Status.FIRE_IMMUNE)){
        actor.hurt(getDamage());
      }
    }
  }
}
