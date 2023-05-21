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

/**
 * Class that represents Merchant Kale, a trader who allows the player to buy/sell items
 *
 * @author Emily Jap
 * @version 1.0.0
 * @see Trader
 */
public class MerchantK extends Trader {
    /**
     * Constructor instantiating this specific trader
     */
    public MerchantK() {
        super("Merchant Kale", 'K', 1);
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
        ActionList actions = new ActionList();

        actions.add(new BuyAction(new Club()));
        actions.add(new BuyAction(new Scimitar()));

        return actions;
    }


}
