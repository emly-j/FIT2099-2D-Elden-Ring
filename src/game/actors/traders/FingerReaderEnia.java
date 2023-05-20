package game.actors.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.BuyAction;
import game.items.weapons.Club;
import game.items.weapons.Scimitar;
import game.utils.Status;

public class FingerReaderEnia extends Trader{

    public FingerReaderEnia(){
        super("Finger Reader Enia", 'E', 1);
        this.addCapability(Status.ACCEPT_GODRICK_DROP);
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();

    }

    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions= new ActionList();

//        actions.add(new ExchangeAction(new __))
//todo, add an exhange action for 2 weapons
        return actions;
    }

}
