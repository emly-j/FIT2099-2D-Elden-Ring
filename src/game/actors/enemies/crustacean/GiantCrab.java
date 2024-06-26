package game.actors.enemies.crustacean;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AreaAttackBehaviour;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * Class that represents the GiantCrab actor
 *
 * @author Hayden Tran
 * @author Emily Jap
 * @version 1.0.0
 */
public class GiantCrab extends Crustacean implements RuneSource {
    /**
     * Constructor.
     */
    public GiantCrab() {
        super("Giant Crab", 'C', 407);
        this.addCapability(Status.PERFORM_AREA_ATTACK);
        behaviours.put(3, new AreaAttackBehaviour());
        addRuneSource();
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(318, 4961));
        runeManager.addRuneSource(this);
    }
}
