package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Breakable;

public class BreakAction extends Action {

    private Breakable breakable;
    private Location breakableLocation;

    public BreakAction(Breakable breakable, Location breakableLocation) {
        this.breakable = breakable;
        this.breakableLocation = breakableLocation;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return breakable.broken(actor, breakableLocation);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " breaks the " + breakable;
    }
}
