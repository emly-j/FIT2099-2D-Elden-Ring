package game.actors.enemies.skeleton;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.skeleton.Skeleton;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.utils.RandomNumberGenerator;
import game.utils.Utils;
import game.actions.AreaAttackAction;
import game.actors.AttackType;
import game.behaviours.AreaAttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.utils.Status;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.items.weapons.Grossmesser;

import java.util.HashMap;


/**
 * Class that represents the Heavy Skeletal Swordsman extending from a skeleton
 * @author Emily Jap
 * @version 1.0.0
 * @see Skeleton
 */
public class HeavySkeletalSwordsman extends Skeleton implements RuneSource {

    /**
     * Constructor that instantiates the actor with its starting weapon
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        addWeaponToInventory(new Grossmesser());
        behaviours.put(10, new AttackBehaviour(new Grossmesser()));
    }

    /**
     * Adds rune source to lists/maps in RuneManager
     *
     * @see RuneManager
     */
    @Override
    public void addRuneSource() {
        RuneManager runeManager = RuneManager.getInstance();
        runeManager.addRuneOwner(this, RandomNumberGenerator.getRandomInt(35, 892));
        runeManager.addRuneSource(this);
    }
}
