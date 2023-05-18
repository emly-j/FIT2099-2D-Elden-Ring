package game.actors.enemies.canine;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actors.AttackType;
import game.behaviours.AreaAttackBehaviour;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.utils.Utils;

import java.util.HashMap;

/**
 * Class that represents the Giant Dog actor
 * @author Emily Jap
 * @version 1.0.0
 */
public class GiantDog extends Canine implements RuneSource {
    /**
     * Constructor that instantiates the actor with being able to hold a random amount of runes
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        behaviours.put(3, new AreaAttackBehaviour());
        addRuneSource();
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(693, "head slams", 90);
    }


    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(55, 1470));
        runeManager.addRuneSource(this);
    }
}

