package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.Enemy;
import game.environments.RuneFloor;
import game.ResetManager;
import game.RuneManager;
import game.RuneSource;
import game.Status;

import static game.FancyMessage.YOU_DIED;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class DeathAction extends Action {
    private Actor attacker;
    private int runesHeld;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     *When PLAYER (hostile to enemy) dies, creates an instance of runefloor to be a runesource that can hold the runes that player holds
     * sets the floor of location to hold the mount of runes and then subtract the player amount to be 0
     * move the player to location after dying
     * then runs the reesets as per the requirements
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */

    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        ActionList dropActions = new ActionList();
        // drop all items
        if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) { //checks if it is a player
            // since in requirement playe dies weapons and items arent reset, this these lines are commented out
//            for (Item item : target.getItemInventory())
//                dropActions.add(item.getDropAction(target));
//            for (WeaponItem weapon : target.getWeaponInventory())
//                dropActions.add(weapon.getDropAction(target));
//            for (Action drop : dropActions)
//                drop.execute(target, map);
            if (!target.hasCapability(Status.RESTED)){ //checks if actor has rested, this runs if NOT rested
                runesHeld = RuneManager.getInstance().getRunes(target); //use to print amount dropped
                RuneFloor droppedRune = new RuneFloor(); // create new runefloor to hold the runes from our player when we die
                // TODO: find another way of storing runeFloor
                //RuneManager.getInstance().addRunes(droppedRune, RuneManager.getInstance().getRunes(target)); //update the amount of runes that player has to be the floor has
                map.at(map.locationOf(target).x(), map.locationOf(target).y()).setGround(droppedRune); //setground to the runefloor at location of the player
                RuneManager.getInstance().subtractRunes(target, RuneManager.getInstance().getRunes(target)); // subtract all the runes of player to = 0
                target.addCapability(Status.DROPPED);
                map.moveActor(target, map.at(30, 10)); //when die, want to move them to coords of siteoflostgrace
                ResetManager.getInstance().runReset(); //reset the game state as required
                return System.lineSeparator() + YOU_DIED + System.lineSeparator() + target + " Dropped: " + runesHeld + " runes";

            }
            map.moveActor(target, map.at(30, 10)); //when die, want to move them to coords of siteoflostgrace
            ResetManager.getInstance().runReset(); //reset the game state as required

            return System.lineSeparator() + YOU_DIED;
//            return System.lineSeparator() + menuDescription(target);
        } else { //otherwise it is enemy who has death action and drops everything

            if(attacker.hasCapability(Status.HOSTILE_TO_ENEMY)){
                RuneManager runeManager = RuneManager.getInstance();
                runeManager.transfer(attacker, target);
            }

            for (Item item : target.getItemInventory())
                dropActions.add(item.getDropAction(target));
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            map.removeActor(target);
            result += System.lineSeparator() + menuDescription(target);

            return result;
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " has been slain.";
    }
}
