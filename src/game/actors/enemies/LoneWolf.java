package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.RandomNumberGenerator;
import game.RuneManager;
import game.RuneSource;
import game.Status;

/**
 * BEHOLD, DOG!
 * Class that represents the LoneWolf actor in the game
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Emily Jap
 * @version 1.0.0
 */
public class LoneWolf extends Canine implements RuneSource {

    /**
     * Constructor which instantiates the attributes for an enemy and adds it to be a runesource
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        addRuneSource();
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
