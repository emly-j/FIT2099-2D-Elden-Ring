package game.actors.enemies.skeleton;

import game.behaviours.AttackBehaviour;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.items.weapons.Grossmesser;
import game.utils.RandomNumberGenerator;


/**
 * Class that represents the Heavy Skeletal Swordsman extending from a skeleton
 *
 * @author Emily Jap
 * @version 1.0.0
 * @see Skeleton
 */
public class HeavySkeletalSwordsman extends Skeleton implements RuneSource {

    /**
     * Constructor that instantiates the actor with its starting weapon
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        addWeaponToInventory(new Grossmesser());
        behaviours.put(10, new AttackBehaviour(new Grossmesser()));
    }

    /**
     * Adds rune source to lists/maps in RuneManager
     *
     * @see RuneManager
     */
    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(35, 892));
        runeManager.addRuneSource(this);
    }
}
