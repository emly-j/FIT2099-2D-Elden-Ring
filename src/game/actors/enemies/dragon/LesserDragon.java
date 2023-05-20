package game.actors.enemies.dragon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.*;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;

public class LesserDragon extends Dragon implements RuneSource {

  /**
   * Constructor that instantiates the base Enemy behaviours and being a resettable instance
   */
  public LesserDragon() {
    super("Lesser Dragon", 'd', 400);
    addRuneSource();
    behaviours.put(520, new BreatheFireBehaviour());
  }

  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(100, "flames", 90);
  }

  @Override
  public void addRuneSource() {
    RuneManager runeManager = RuneManager.getInstance();
    runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(500, 2500));
    runeManager.addRuneSource(this);
  }
}
