package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.PileOfBones;

public class BecomePileOfBonesAction extends Action {

    private Actor revivableActor;
    private Location revivableActorLocation;

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
