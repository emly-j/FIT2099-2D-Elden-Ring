package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.RandomNumberGenerator;
import game.RuneManager;
import game.RuneSource;
import game.Status;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class LoneWolf extends Canine {

    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        RuneManager.getInstance().addRuneOwner(this, RandomNumberGenerator.getRandomInt(55,1470));
        System.out.println("I am doggy" + RuneManager.getInstance().getRunes(this));

    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }


//    @Override
//    public void addRuneSource() {
//
//    }
}
