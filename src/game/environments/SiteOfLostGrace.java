package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.Status;

public class SiteOfLostGrace extends Ground {

    /**
     * Constructor.
     *
     * @param  
     */
    public SiteOfLostGrace() {
        super('U');
        this.addCapability(Status.RESETABLE);
    }


//    public void tick(Location location, Actor actor) {
//        if (location.containsAnActor()){
//
//        }

    //    }

    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
}
