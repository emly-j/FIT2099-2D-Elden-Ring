package game.actors.enemies.canine;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.AttackType;
import game.actors.enemies.Enemy;
import game.behaviours.AreaAttackBehaviour;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;

/**
 * Class that represents the Giant Dog actor
 *
 * @author Emily Jap
 * @version 1.0.0
 */
public class GiantDog extends Enemy implements RuneSource {
    /**
     * Constructor that instantiates the actor with being able to hold a random amount of runes
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        behaviours.put(3, new AreaAttackBehaviour());
        addCapability(AttackType.CANNOT_ATTACK_CANINES);
        addRuneSource();
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(693, "head slams", 90);
    }


    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(55, 1470));
        runeManager.addRuneSource(this);
    }
}

