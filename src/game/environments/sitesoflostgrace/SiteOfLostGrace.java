package game.environments.sitesoflostgrace;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RestAction;
import game.utils.Status;

public abstract class SiteOfLostGrace extends Ground {
    /**
     * Constructor that instanatites the display value
     */
    String name;

    public SiteOfLostGrace(String name) {
        super('U');
        this.name = name;

    }

    /**
     * A boolean to check whether a PLAYER can enter or not
     *
     * @param actor the Actor to check
     * @return true if has Status.HOSTILE_TO_ENEMY (player checker)
     */
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    /**
     * The updates ActionList for the actor when they enter this ground
     *
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return any actions added (Rest Action if possible)
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (location.containsAnActor()) {
            actions.add(new RestAction(this, location, this.name));
        }
        return actions;
    }
}
