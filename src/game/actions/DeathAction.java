package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.controllers.LastLocationManager;
import game.controllers.ResetManager;
import game.controllers.RestLocationManager;
import game.controllers.RuneManager;
import game.utils.Status;
import game.items.runes.Rune;

import static game.utils.FancyMessage.YOU_DIED;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Hayden Tran
 * @author Emily Jap
 * @version 1.0.0
 * @see Action
 */
public class DeathAction extends Action {
    private Actor attacker;
    private int runesHeld;

    /**
     * Constructor.
     * @param actor
     */
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

            if (!target.hasCapability(Status.RESTED)){ //checks if actor has rested, this runs if NOT rested
                runesHeld = RuneManager.getInstance().getRunes(target); //use to print amount dropped
                if (target.hasCapability(Status.PLAYERDIEDTWICE)) {
                    target.removeCapability(Status.PLAYERDIEDTWICE);
                    target.addCapability(Status.PLAYERDIED);
                }
                Rune runesDropped = new Rune(runesHeld, target); // creating new rune instance poklayer holds

                map.at(LastLocationManager.getLastRestedLocation().x(),LastLocationManager.getLastRestedLocation().y()).addItem(runesDropped);
//                map.at(map.locationOf(target).x(), map.locationOf(target).y()).addItem(runesDropped); //adds this item to the map
                runesDropped.setCounter(1); //setting counter to 1, next reset will = 0 and disappear
                RuneManager.getInstance().subtractRunes(target, runesHeld);
                System.out.println("RUNES ARE HOLDING " + runesDropped.getValue());
                map.moveActor(target, RestLocationManager.getLastRestedLocation());
//                map.moveActor(target, map.at(30, 10)); //when die, want to move them to coords of siteoflostgrace
                addCapabilityPlayerDeath(target);
                ResetManager.getInstance().runReset(); //reset the game state as required

                return System.lineSeparator() + YOU_DIED + System.lineSeparator() + target + " dropped " + runesHeld + " runes";

            }
            map.moveActor(target, RestLocationManager.getLastRestedLocation());
            ResetManager.getInstance().runReset(); //reset the game state as required

            return System.lineSeparator() + YOU_DIED;

        } else { //otherwise it is enemy who has death action and drops everything

            // transfer runes to player when they kill a target
            if(attacker.hasCapability(Status.HOSTILE_TO_ENEMY)){
                RuneManager runeManager = RuneManager.getInstance();
                result += runeManager.transfer(attacker, target);
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

    /**
     * A method that adds capabilities when the player has died
     * @param target
     */
    public void addCapabilityPlayerDeath(Actor target){
        if (!target.hasCapability(Status.PLAYERDIED) && !target.hasCapability(Status.PLAYERDIEDTWICE)) {
            target.addCapability(Status.PLAYERDIED); //indicate that player has died once.
        }
        else if(target.hasCapability(Status.PLAYERDIED) && !target.hasCapability(Status.PLAYERDIEDTWICE)){
            target.removeCapability(Status.PLAYERDIED);
            target.addCapability(Status.PLAYERDIEDTWICE);
        }
    }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " has been slain.";
    }
}
