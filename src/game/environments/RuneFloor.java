package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RetrieveRuneAction;
import game.RuneManager;
import game.RuneSource;
import game.Status;

public class RuneFloor extends Ground implements RuneSource {

    private int counter;

    /**
     * Constructor.
     *
     */
    public RuneFloor() {
        super('$');
        RuneManager.getInstance().addRuneOwner(this);
        counter = 1;
    }

    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }


//    @Override
//    public void tick(Location location) {
//        Actor tempplayer = location.getActor();
//        if (tempplayer.hasCapability(Status.DROPPED));
//            counter -=1; location.
//        if (counter < 0){
//            location.setGround(new Dirt());
//        }
//    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {

        ActionList actions = new ActionList();
        if (location.containsAnActor()) {
            actions.add(new RetrieveRuneAction());
        } return actions;
    }

    @Override
    public void addRunes(int amount) {
        RuneManager.getInstance().addRunes(this, amount);
    }
}

