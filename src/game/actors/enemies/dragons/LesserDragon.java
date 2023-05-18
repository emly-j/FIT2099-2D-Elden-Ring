package game.actors.enemies.dragons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actors.AttackType;
import game.behaviours.AreaAttackBehaviour;
import game.behaviours.AttackBehaviour;
import game.behaviours.BreatheFireBehaviour;
import game.behaviours.FollowBehaviour;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class LesserDragon extends Dragon implements RuneSource {

  /**
   * Constructor that instantiates the base Enemy behaviours and being a resettable instance
   */
  public LesserDragon() {
    super("Lesser Dragon", 'd', 400);
    addRuneSource();
  }

  @Override
  public ActionList allowableActions(Actor otherActor, String direction, GameMap map){
    // these behaviours can occur when there are other actors in the surrounding area
    behaviours.put(998, new FollowBehaviour(otherActor));
    behaviours.put(2, new AttackBehaviour());

    ActionList actions= new ActionList();
    // actions the player or other enemy types can do to this actor
    if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && !otherActor.hasCapability(
        AttackType.CANNOT_ATTACK_DRAGONS)){
      actions.add(new AttackAction(this, direction));

      if(otherActor.getWeaponInventory() != null){
        for(int i = 0; i<otherActor.getWeaponInventory().size(); i++){
          actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(i)));
        }
      }
    }

    allowAreaAttack(otherActor, map, actions);
    return actions;
  }

  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(100, "flames", 100);
  }

  @Override
  public void addRuneSource() {
    RuneManager runeManager = RuneManager.getInstance();
    runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(500, 2500));
    runeManager.addRuneSource(this);
  }
}
