package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.controllers.Consumable;

/**
 * A consume action which represents all item that should be consumed
 * @author Hayden Tran
 * @version 1.0.0
 * @see Action
 */
public class ConsumeAction extends Action {

    private Consumable itemToConsume;
    private int health;

    /**
     * Constructor which takes in these parameters to determine which item to consume and how much to heal
     * @param itemToConsume
     * @param health
     */
    public ConsumeAction(Consumable itemToConsume, int health) {
        this.itemToConsume = itemToConsume;
        this.health = health;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (this.itemToConsume.getCharges() > 0) {
            actor.heal(this.health);
            this.itemToConsume.reduceCharges();
            return actor + " healed for " + this.health + " HP";
        } else {
            return "Failed to heal, no more charges";
        }
    }


    @Override
    public String menuDescription(Actor actor) {
        return "Use the " + this.itemToConsume + this.itemToConsume.chargesString();
    }


}
