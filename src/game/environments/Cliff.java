package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DeathAction;

import game.utils.Status;

//import static sun.net.www.http.KeepAliveCache.result;

public class Cliff extends Ground {
    /** Constructor.
     *
     *  character to display for this type of terrain
     */
    public Cliff() {
        super('+');
    }



    /** A boolean to check whether a PLAYER can enter or not
     * @param actor the Actor to check
     * @return true if has Status.HOSTILE_TO_ENEMY (player checker)
     */
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.PLAYER);
    }

    public void tick(Location location) {
        String result = null;
        if (location.containsAnActor()) {
            result = "";
            location.getActor().hurt(999999);
            result += new DeathAction(location.getActor()).execute(location.getActor(), location.map());

        }
    }



}