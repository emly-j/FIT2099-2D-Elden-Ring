package game.controllers;


import edu.monash.fit2099.engine.actors.Actor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hayden Tran
 */
public class RuneManager {


    /**
     * Hash map of actors that hold runes in the game and how many runes they carry.
     */
    private HashMap<Actor, Integer> runeOwners;

    /**
     * A list of rune sources in the game. Rune sources can generate Runes or allow such transfer.
     */
    private ArrayList<RuneSource> runeSources;

    private static RuneManager instance = null;

    private RuneManager() {
        this.runeOwners = new HashMap<>();
        this.runeSources = new ArrayList<>();
    }

    /**
     * Checks if we have instance not, if not create and return it, otherwise just return the instance we have
     * @return
     */
    public static RuneManager getInstance() {
        if (instance == null)
            instance = new RuneManager();
        return instance;
    }

    /**
     * getter for the runeOwner hashmap
     * @return
     */
    public Map<Actor, Integer> getRuneOwners() {
        return runeOwners;
    }

    /**
     * getter for the runeSources list
     * @return
     */
    public List<RuneSource> getRuneSources() {
        return runeSources;
    }

    /**
     * Gets number of runes actor is holding
     * @param source the actor that we are check the runes of
     * @return runes that this actor is holding
     */
    public int getRunes(Actor source) {
        if (canActorHoldRunes(source) == true) { //we check if THIS actor is in the runeOwner Hashmap
            return runeOwners.get(source);
        }
        return 0;
    }

    /**
     * adds a RuneOwner to the hashmap
     * @param owner the actor who owns and holds the runes
     * @param runeAmount the amount of runes the actor holds
     */
    public void addRuneOwner(Actor owner, int runeAmount) {
        if (runeOwners.get(owner) == null) {
            runeOwners.put(owner, runeAmount);
        }
    }

    /**
     * adds a RuneSource to the list of rune sources
     *
     * @param runeSource a RuneSource object that is a source of runes
     */
    public void addRuneSource(RuneSource runeSource) {
        runeSources.add(runeSource);
    }

    /**
     * Removes a RuneOwner from the hashmap
     * @param owner the actor who owns and holds the runes
     */
    public void removeRuneOwner(Actor owner) {
        runeOwners.remove(owner);
    }

    /**
     * Removes a RuneSource from the list
     * @param source the rune source to be removed
     */
    public void removeRuneSource(RuneSource source) {
        runeSources.remove(source);
    }

    /**
     * checking if our hashmap contains our parameter 'actor' determining if it can hold runes or not
     * If it is, return true
     *
     * @param actor
     */
    public boolean canActorHoldRunes(Actor actor) {
        return runeOwners.containsKey(actor);
    }

    /**
     * Checks if an actor is a rune source
     * @param actor
     * @return
     */
    public boolean actorIsRuneSource(Actor actor) {return runeSources.contains(actor);}

    /**
     * Adds runes to a rune owner
     * checks if the key is empty or not then adds as required if can hold runes
     * @param runeOwner
     * @param amountAdded
     */

    public void addRunes(Actor runeOwner, int amountAdded) {
        if (!(runeOwners.get(runeOwner) == null)){ //checks if the amount of runes set to null, indicating an empty set/ this runeholder has no runes
            int updatedAmount = runeOwners.get(runeOwner) + amountAdded;
            runeOwners.put(runeOwner, updatedAmount);
        }
    }

    /**
     * Subtracts runes from a rune owner
     * checks if the key is empty or not then adds as required if can hold runes
     * @param runeOwner
     * @param amountSubtracted
     */
    public void subtractRunes(Actor runeOwner, int amountSubtracted) {
        if (!(runeOwners.get(runeOwner) == null)) { // no extra condition here because we should check it in the purchases that we make
            int updatedAmount = runeOwners.get(runeOwner) - amountSubtracted;
            runeOwners.put(runeOwner, updatedAmount);
        }
    }

    /**
     * Transfer runes between two actors that are rune sources
     */
    public String transfer(Actor attacker, Actor target){
        String result = null;

        // identify runeSource (target)
        if (actorIsRuneSource(target)){
            // add runes to attacker
            int runesToTransfer = getRunes(target);
            int existingRunes = getRunes(attacker);
            result += "\n" + runesToTransfer + " runes were dropped and transferred to " + attacker;
            addRunes(attacker, runesToTransfer + existingRunes);

            // remove runesource from hashmap
            removeRuneOwner(target);
        }

        return result;
    }

}
