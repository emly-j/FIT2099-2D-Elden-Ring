package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actions.RemoveAction;
import game.behaviours.*;
import game.controllers.ResetManager;
import game.controllers.Resettable;
import game.utils.Status;

import java.util.Map;
import java.util.TreeMap;

/**
 * Class the represents the base enemy class and instantiates the behaviours that are similar to all enemies
 *
 * @author Hayden Tran
 * @author Emily Jap
 * @version 2.0.0
 */
public abstract class Enemy extends Actor implements Resettable {

    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Constructor that instantiates the base Enemy behaviours and being a resettable instance
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        behaviours.put(999, new WanderBehaviour());
        behaviours.put(2, new AttackBehaviour());
        behaviours.put(900, new DespawnBehaviour());
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(Status.RESETTABLE)) {
            return new RemoveAction();
        }

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);

            if (action != null) {
                return action;
            }
        }

        return new DoNothingAction();
    }

    /**
     * An enemy can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        // add behaviours that require otherActor as input
        behaviours.put(600, new FollowBehaviour(otherActor));

        // actions the player can do to an enemy
        ActionList actions = new ActionList();
        allowPlayerAttack(otherActor, direction, actions);
        allowAreaAttack(otherActor, map, actions);

        return actions;
    }

    /**
     * A method to allow actors with Status.HOSTILE_TO_ENEMY capability to perform attacks on the enemy
     *
     * @param otherActor the actor that might be performing attacks
     * @param direction  String representing the direction of the other Actor
     * @param actions    list of allowable actions the other actor can to do the enemy
     */
    protected void allowPlayerAttack(Actor otherActor, String direction, ActionList actions) {
        // If player has a weapon with area attack capability, put area attack on list of allowable actions
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));

            if (otherActor.getWeaponInventory() != null) {
                for (int i = 0; i < otherActor.getWeaponInventory().size(); i++) {
                    actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(i)));
                }
            }
        }
    }

    /**
     * A method to allow the actors with the capability Status.PERFORM_AREA_ATTACK to perform area attacks
     * on the current enemy
     *
     * @param otherActor actor that may perform area attack
     * @param map        current GameMap
     * @param actions    list of allowable actions the other actor can to do the enemy
     */
    protected void allowAreaAttack(Actor otherActor, GameMap map, ActionList actions) {
        if (otherActor.hasCapability(Status.PERFORM_AREA_ATTACK)) {

            // check for AOE weapons, otherwise use intrinsic weapon
            if (otherActor.getWeaponInventory() != null) {
                for (int i = 0; i < otherActor.getWeaponInventory().size(); i++) {
                    WeaponItem weapon = otherActor.getWeaponInventory().get(i);
                    if (weapon.hasCapability(Status.PERFORM_AREA_ATTACK)) {
                        actions.add(new AreaAttackAction(weapon));
                    }
                }
            } else {
                actions.add(new AreaAttackAction(otherActor.getIntrinsicWeapon()));
            }
        }
    }

    @Override
    public void reset() {
        this.addCapability(Status.RESETTABLE);
    }
}
