package game;


import edu.monash.fit2099.engine.actors.Actor;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hayden Tran
 */
public class RuneManager {


    /**
     * hash map which will tell us who holds teh runes and how many
     */
    private Map<Actor, Integer> runeOwner;
    private static RuneManager instance = null;

    private RuneManager() {
        this.runeOwner = new HashMap<>();
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
    public Map<Actor, Integer> getRuneOwner() {
        return runeOwner;
    }

    /**
     * Gets number of runes actor is holding
     * @param actor checking how many runes they are holding (if possible)
     * @return runes that this actor is holding
     */
    public int getRunes(Actor actor) {
        if (canActorHoldRunes(actor) == true) { //we check if THIS actor is in the runeOwner Hashmap
            return runeOwner.get(actor);
        }
        return 0;
    }

    /**
     * adds an actor to the hashmap
     * @param owner the actor who owns and holds the runes
     */
    public void addRuneOwner(Actor owner) {
        if (runeOwner.get(owner) == null) {
            runeOwner.put(owner, 0);
        }
    }

    /**
     * checking if our hashmap contains our parameter 'actor' determining if it can hold runes or not
     * If it is, return true
     * @param actor
     * @return
     */
    public boolean canActorHoldRunes(Actor actor) {
        return runeOwner.containsKey(actor);
    }

    /**
     * adding and subtracting methods for runes,
     * checks if the key is empty or not then adds/subtracts as required if can hold runes
     * @param runeHolder
     * @param amountAdded
     */

    public void addRunes(Actor runeHolder, int amountAdded) {
        if (!(runeOwner.get(runeHolder) == null)){ //checks if the amount of runes set to null, indicating an empty set/ this runeholder has no runes
            int updatedAmount = runeOwner.get(runeHolder) + amountAdded;
            runeOwner.put(runeHolder, updatedAmount);
        }
    }
    public void subtractRunes(Actor runeHolder, int amountSubtracted) {
        if (!(runeOwner.get(runeHolder) == null)) { // no extra condition here because we should check it in the purchases that we make
            int updatedAmount = runeOwner.get(runeHolder) - amountSubtracted;
            runeOwner.put(runeHolder, updatedAmount);
        }
    }




}
