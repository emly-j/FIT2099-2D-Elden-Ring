package game.actors.enemies.canine;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.AttackType;
import game.controllers.Resettable;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;

public class Dog extends Canine implements RuneSource {
    /**
     * Constructor that instantiates the base canine with their capability of not being able to attack other canines
     */
    public Dog() {
        super("Dog", 'a', 104);
        addCapability(AttackType.CANNOT_ATTACK_GODRICK_SOLDIERS);
        addCapability(AttackType.CANNOT_ATTACK_DOGS); // todo: check if dogs can attack other dogs
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
