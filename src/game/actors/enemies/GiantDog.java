package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.RandomNumberGenerator;
import game.RuneManager;
import game.Status;

public class GiantDog extends Canine{
    /**
     * Constructor.
     *
     * name        the name of the Actor
     *  displayChar the character that will represent the Actor in the display
     * hitPoints   the Actor's starting hit points
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        this.addCapability(Status.PERFORM_AREA_ATTACK);
        RuneManager.getInstance().addRuneOwner(this, RandomNumberGenerator.getRandomInt(313,1808));
        System.out.println("I big doggy" + RuneManager.getInstance().getRunes(this));
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "sitting slam", 90);
    }
}



