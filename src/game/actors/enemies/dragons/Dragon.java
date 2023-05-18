package game.actors.enemies.dragons;

import game.actors.AttackType;
import game.actors.enemies.Enemy;
import game.behaviours.BreatheFireBehaviour;

public abstract class Dragon extends Enemy {

  /**
   * Constructor that instantiates the base Enemy behaviours and being a resettable instance
   *
   * @param name        the name of the Actor
   * @param displayChar the character that will represent the Actor in the display
   * @param hitPoints   the Actor's starting hit points
   */
  public Dragon(String name, char displayChar, int hitPoints) {
    super(name, displayChar, hitPoints);
    addCapability(AttackType.CANNOT_ATTACK_DRAGONS);
    behaviours.put(520, new BreatheFireBehaviour());
  }
}
