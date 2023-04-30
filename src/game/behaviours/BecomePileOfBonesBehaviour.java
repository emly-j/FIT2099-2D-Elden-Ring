package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.BecomePileOfBonesAction;

public class BecomePileOfBonesBehaviour implements Behaviour {
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (!actor.isConscious()){
            return new BecomePileOfBonesAction(actor, map.locationOf(actor));
        }
        else {
            return null;
        }
    }
}