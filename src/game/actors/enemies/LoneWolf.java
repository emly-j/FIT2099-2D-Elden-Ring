package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

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
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}