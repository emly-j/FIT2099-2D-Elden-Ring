package game.actors.enemies.dragon;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.enemies.Enemy;
import game.behaviours.*;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents the Lesser Dragon enemy
 * @author Emily Jap
 * @version 1.0.0
 * @see Dragon
 */
public class LesserDragon extends Dragon implements RuneSource {

  /**
   * Constructor
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
