package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RestAction;
import game.utils.Status;

public class TheFirstStep extends Ground {
    /**
     * Constructor.
     *
     * @param
     */
    public TheFirstStep() {
        super('U');
    }

    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {

        ActionList actions = new ActionList();
        if (location.containsAnActor()) {
            actions.add(new RestAction());
        } return actions;
    }

}
