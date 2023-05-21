package game.controllers;


import edu.monash.fit2099.engine.actors.Actor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class that keeps track of RuneSources in the game and manages transfer of runes
 *
 * @author Hayden Tran
 * @author Emily Jap
 * @version 1.0.0
 */
public class RuneManager {


    /**
     * Hash map of actors that hold runes in the game and how many runes they carry.
     */
    private final HashMap<Actor, Integer> runeOwners;

    /**
     * A list of rune sources in the game. Rune sources can generate Runes or allow such transfer.
     */
    private final ArrayList<RuneSource> runeSources;

    private static RuneManager instance = null;

    /**
     * Constructor.
     */
    private RuneManager() {
        this.runeOwners = new HashMap<>();
        this.runeSources = new ArrayList<>();
    }

    /**
     * A factory method that generates or returns the instance of RuneManager
     *
     * @return a RuneManager instance
     */
    public static RuneManager getInstance() {
        if (instance == null)
            instance = new RuneManager();
        return instance;
    }

    /**
     * Getter for the runeOwner hashmap
     *
     * @return hashmap of rune owners in the game
     */
    public HashMap<Actor, Integer> getRuneOwners() {
        return runeOwners;
    }

    /**
     * Getter for the runeSources list
     *
     * @return list of rune sources in the game
     */
    public ArrayList<RuneSource> getRuneSources() {
        return runeSources;
    }

    /**
     * Gets number of runes an actor is holding
     *
     * @param source the actor that we want to check the runes of
     * @return integer representing runes that this actor is holding
     */
    public int getRunes(Actor source) {
        if (canActorHoldRunes(source)) { //we check if THIS actor is in the runeOwner Hashmap
            return runeOwners.get(source);
        }
        return 0;
    }

    /**
     * Adds a RuneOwner to the hashmap
     *
     * @param owner      the actor who owns and holds the runes
     * @param runeAmount the amount of runes the actor initially holds
     */
    public void addRuneOwner(Actor owner, int runeAmount) {
        if (runeOwners.get(owner) == null) {
            runeOwners.put(owner, runeAmount);
        }
    }

    /**
     * Adds a RuneSource to the list of rune sources
     *
     * @param runeSource a RuneSource object that is a source of runes
     */
    public void addRuneSource(RuneSource runeSource) {
        runeSources.add(runeSource);
    }

    /**
     * Removes a RuneOwner from the hashmap
     *
     * @param owner the actor who owns and holds the runes
     */
    public void removeRuneOwner(Actor owner) {
        runeOwners.remove(owner);
    }

    /**
     * Removes a RuneSource from the rune source list
     *
     * @param source the rune source to be removed
     */
    public void removeRuneSource(RuneSource source) {
        runeSources.remove(source);
    }

    /**
     * Checks if an actor is a rune owner
     *
     * @param actor actor we want to check
     * @return boolean indicating if the actor is a rune owner
     */
    public boolean canActorHoldRunes(Actor actor) {
        return runeOwners.containsKey(actor);
    }

    /**
     * Checks if an actor is a rune source
     *
     * @param actor actor we want to check
     * @return boolean indicating if the actor is a rune source
     */
    public boolean actorIsRuneSource(Actor actor) {
        return runeSources.contains(actor);
    }

    /**
     * Adds runes to a rune owner.
     * checks if the actor exists as a rune owner then adds as required
     *
     * @param runeOwner   actor we want to add runes to
     * @param amountAdded amount of runes to add
     */
    public void addRunes(Actor runeOwner, int amountAdded) {
        if (!(runeOwners.get(runeOwner) == null)) { //checks if the amount of runes set to null, indicating an empty set/ this runeholder has no runes
            int updatedAmount = runeOwners.get(runeOwner) + amountAdded;
            runeOwners.put(runeOwner, updatedAmount);
        }
    }

    /**
     * Subtracts runes from a rune owner.
     * checks if the actor exists as a rune owner then subtracts as required
     *
     * @param runeOwner        actor we want to subtract runes from
     * @param amountSubtracted amount of runes to subtract
     */
    public void subtractRunes(Actor runeOwner, int amountSubtracted) {
        if (!(runeOwners.get(runeOwner) == null)) { // no extra condition here because we should check it in the purchases that we make
            int updatedAmount = runeOwners.get(runeOwner) - amountSubtracted;
            runeOwners.put(runeOwner, updatedAmount);
        }
    }

    /**
     * Transfer runes between two actors.
     *
     * @param attacker the actor who will receive runes
     * @param target   the actor who will lose runes
     * @return string indicating the result
     */
    public String transfer(Actor attacker, Actor target) {
        String result = "";

        // identify runeSource (target)
        if (actorIsRuneSource(target)) {
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
