package game.actors.enemies.skeleton;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actors.AttackType;
import game.actors.enemies.skeleton.Skeleton;
import game.behaviours.AreaAttackBehaviour;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.controllers.RuneManager;
import game.controllers.RuneSource;
import game.items.weapons.Grossmesser;
import game.items.weapons.Scimitar;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.utils.Utils;

import java.util.HashMap;


/**
 * This class represents a base Skeletal Bandit
 * @author Hayden Tran
 * @version 1.0.0
 * @see Skeleton
 */
public class SkeletalBandit extends Skeleton implements RuneSource {
    /**
     * Constructor that adds the required weapon Scimitar and instantiates the properties of the skeletal bandit
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184);
        addWeaponToInventory(new Scimitar());
        behaviours.put(10, new AttackBehaviour(new Scimitar()));
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
