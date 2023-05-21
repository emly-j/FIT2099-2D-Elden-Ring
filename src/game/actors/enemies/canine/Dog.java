package game.actors.enemies.canine;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.AttackType;
import game.actors.enemies.Enemy;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;

/**
 * Class that represents the Dog enemy
 *
 * @author Emily Jap
 * @version 1.0.0
 */
public class Dog extends Enemy implements RuneSource {
    /**
     * Constructor.
     */
    public Dog() {
        super("Dog", 'a', 104);
        addCapability(AttackType.CANNOT_ATTACK_GODRICK_SOLDIERS);
        addCapability(AttackType.CANNOT_ATTACK_DOGS);
        removeCapability(AttackType.CANNOT_ATTACK_CANINES);
        addRuneSource();
    }

    /**
     * Adds rune source to lists/maps in RuneManager
     *
     * @see RuneManager
     */
    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(52, 1390));
        runeManager.addRuneSource(this);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }
}
