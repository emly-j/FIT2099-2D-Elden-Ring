package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.environments.damage.FireGround;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.utils.Utils;
import java.util.HashMap;
import java.util.List;

/**
 * An action to set surrounding ground on fire
 * @author Emily Jap
 * @version 1.0.0
 */
public class BreatheFireAction extends Action {

  @Override
  public String execute(Actor actor, GameMap map) {
    Location sourceLocation = map.locationOf(actor);

    // set surroundings on fire
    HashMap<Location, String> rangedLocations = Utils.getRangedLocations(sourceLocation, map);
    for(Location location : rangedLocations.keySet()){

      // if actor cant enter the ranged ground, or ground is fire immune, don't set ground on fire
      Ground ground = location.getGround();
      if(RandomNumberGenerator.getRandomChance(50) && ground.canActorEnter(actor) && !ground.hasCapability(
          Status.FIRE_IMMUNE)){
        location.setGround(new FireGround());
      }
    }

    // set exits on fire
    List<Exit> exits = sourceLocation.getExits();
    for(Exit exit:exits){

      // if actor cant enter the surrounding ground, or ground is fire immune, don't set ground on fire
      Ground ground = exit.getDestination().getGround();
      if(RandomNumberGenerator.getRandomChance(50) && ground.canActorEnter(actor) && !ground.hasCapability(
          Status.FIRE_IMMUNE)){
        exit.getDestination().setGround(new FireGround());
      }
    }

    return actor + " breathes fire";
  }

  @Override
  public String menuDescription(Actor actor) {
    return actor + " breathes fire";
  }
}
