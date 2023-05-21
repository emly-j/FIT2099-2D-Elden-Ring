package game.actors.enemies.skeleton;

import game.behaviours.AttackBehaviour;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.items.weapons.Scimitar;
import game.utils.RandomNumberGenerator;


/**
 * This class represents a base Skeletal Bandit
 *
 * @author Hayden Tran
 * @version 1.0.0
 * @see Skeleton
 */
public class SkeletalBandit extends Skeleton implements RuneSource {
    /**
     * Constructor that adds the required weapon Scimitar and instantiates the properties of the skeletal bandit
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184);
        addWeaponToInventory(new Scimitar());
        behaviours.put(10, new AttackBehaviour(new Scimitar()));
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
