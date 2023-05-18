package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.skeleton.PileOfBones;

/**
 * Class that represents the action for become pile of boners
 * @author Emily Jap
 * @version 1.0.0
 * @see Action
 */
public class BecomePileOfBonesAction extends Action {

    /**
     * The actor the PileOfBones will revive into when it is not hit.
     */
    private Actor revivableActor;

    /**
     * The location where the pile of bones will spawn.
     */
    private Location revivableActorLocation;

    /**
     * Constructor
     * @param revivableActor actor the pile of bones revives into
     * @param revivableActorLocation location where the pile of bones will spawn
     */
    public BecomePileOfBonesAction(Actor revivableActor, Location revivableActorLocation) {
        this.revivableActor = revivableActor;
        this.revivableActorLocation = revivableActorLocation;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(revivableActor);
        revivableActorLocation.addActor(new PileOfBones(revivableActor));

        return revivableActor + " becomes a Pile of Bones ";
    }

    @Override
    public String menuDescription(Actor actor) {
        return revivableActor + " becomes a Pile of Bones ";
    }
}
