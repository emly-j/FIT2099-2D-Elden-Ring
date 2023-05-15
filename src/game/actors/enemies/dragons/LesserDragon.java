package game.actors.enemies.dragons;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class LesserDragon extends Dragon{

  /**
   * Constructor that instantiates the base Enemy behaviours and being a resettable instance
   */
  public LesserDragon() {
    super("Lesser Dragon", 'd', 400);
  }

  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(100, "flames", 100);
  }
}
