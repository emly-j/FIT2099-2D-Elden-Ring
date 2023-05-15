package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.utils.Utils;
import java.util.HashMap;

public class RangedAttackAction extends Action {

  /**
   * Weapon used for the attack
   */
  private Weapon weapon;

  /**
   * Constructor with intrinsic weapon as default.
   */
  public RangedAttackAction(){}

  /**
   * Constructor.
   * @param weapon   the weapon used to perform the attack
   */
  public RangedAttackAction(Weapon weapon) {
    this.weapon = weapon;
  }

  @Override
  public String execute(Actor actor, GameMap map) {
    String result = actor + " performs ranged attack \n";

    // get intrinsic weapon if possible
    if (weapon == null) {
      weapon = actor.getIntrinsicWeapon();
    }

    // go through list of targets and create attack action for each
    HashMap<Actor, String> targets = Utils.getRangedActors(actor,map);

    for(Actor target: targets.keySet()){
      AttackAction attackAction = new AttackAction(target, targets.get(target), weapon);
      result += attackAction.execute(actor, map) + "\n";
    }

    return result;

  }

  @Override
  public String menuDescription(Actor actor) {
    return actor + " performs ranged attack \n";
  }
}
