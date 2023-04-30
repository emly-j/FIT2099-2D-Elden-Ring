package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.RandomNumberGenerator;
import game.RuneManager;

public class GiantCrayfish extends Crustacean{
    /**
     * Constructor.
     *
     *
     */
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803);
        RuneManager.getInstance().addRuneOwner(this, RandomNumberGenerator.getRandomInt(500,2374));
        System.out.println("I am bigfish" + RuneManager.getInstance().getRunes(this));

    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "pincer slam", 100);
    }
}
