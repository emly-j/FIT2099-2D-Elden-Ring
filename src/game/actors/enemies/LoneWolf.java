package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.Status;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class LoneWolf extends Canine implements RuneSource {

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
