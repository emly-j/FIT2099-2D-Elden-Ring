package game.actors.enemies.crustacean;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AreaAttackBehaviour;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * Class that represents the GiantCrayfish actor
 *
 * @author Hayden Tran
 * @author Emily Jap
 * @version 1.0.0
 */

public class GiantCrayfish extends Crustacean implements RuneSource {
    /**
     * Constructor that instantiates the actor
     */
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803);
        this.addCapability(Status.PERFORM_AREA_ATTACK);
        behaviours.put(3, new AreaAttackBehaviour());
        addRuneSource();
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "pincer slams", 100);
    }

    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(500, 2374));
        runeManager.addRuneSource(this);
    }
}
