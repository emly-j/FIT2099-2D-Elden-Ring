package game.actors.enemies.canine;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.AttackType;
import game.actors.enemies.Enemy;
import game.controllers.ResetManager;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * BEHOLD, DOG!
 * Class that represents the LoneWolf actor in the game
 * <p>
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 * @author Emily Jap
 * @version 1.0.0
 * @see Enemy
 */
public class LoneWolf extends Enemy implements RuneSource {

    /**
     * Constructor which instantiates the attributes for an enemy and adds it to be a runesource
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        addRuneSource();
        ResetManager.getInstance().registerResettable(this);
        addCapability(AttackType.CANNOT_ATTACK_CANINES);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

    @Override
    public void reset() {
        this.addCapability(Status.RESETTABLE);

    }

    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(55, 1470));
        runeManager.addRuneSource(this);
    }


}
