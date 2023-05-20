package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DeathAction;

import game.utils.Status;

import static game.utils.FancyMessage.YOU_DIED;

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
            Display display = new Display();
            result = "";
            location.getActor().hurt(999999999);
            System.out.println(location.getActor());
            display.println(location.getActor() + " fell off a cliff");
            display.println(YOU_DIED);
            result += new DeathAction(location.getActor()).execute(location.getActor(), location.map());
        }
    }



}