package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.controllers.RuneManager;
import game.items.runes.Rune;
import game.utils.Status;

/**
 * Class that represents a retrieve rune action
 * @author Hayden Tran
 * @version 1.0.0
 * @see RetrieveAction
 */
public class RetrieveRuneAction extends RetrieveAction {
    private final Rune rune;

    /**
     * Constructor that takes in the rune to be retrieved
     * @param rune
     */
    public RetrieveRuneAction(Rune rune) {
        super(rune);
        this.rune = rune;
    }

    /**
     * When executed, updates the players Rune hashmap with the amount of runes this rune was holding
     * then removes the rune from the map
     * and removes PLAYERDIED capability from the actor (this resets the death method in deathaction)
     * @see DeathAction
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        RuneManager.getInstance().addRunes(actor, rune.getValue());
        map.locationOf(actor).removeItem(rune);
        if (actor.hasCapability(Status.PLAYERDIED)) {
            actor.removeCapability(Status.PLAYERDIED);
        }

        return actor + " now has " + RuneManager.getInstance().getRunes(actor) + " runes";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Retrieve runes (value: " + rune.getValue() + ")";
    }
}

