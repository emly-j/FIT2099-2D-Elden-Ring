package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.controllers.RuneManager;
import game.items.Rune;
import game.utils.Status;


public class RetrieveRuneAction extends RetrieveAction {

    private final Rune rune;

    public RetrieveRuneAction(Rune rune) {
        super(rune);
        this.rune = rune;
    }

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

