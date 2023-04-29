package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.environments.Dirt;
import game.RuneManager;
import game.RuneSource;

public class RetrieveRuneAction extends Action {
    private int tempRune;

    @Override
    public String execute(Actor actor, GameMap map) {
        this.tempRune = RuneManager.getInstance().getRunes((RuneSource) map.locationOf(actor).getGround());
        map.locationOf(actor).setGround(new Dirt());
        RuneManager.getInstance().addRunes((RuneSource) actor, this.tempRune);

        return actor + " retrieved " + this.tempRune + " runes (now holding " + RuneManager.getInstance().getRunes((RuneSource) actor) + ")";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Retrieve Runes";
    }
}
