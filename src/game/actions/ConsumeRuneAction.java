package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.controllers.Consumable;
import game.controllers.RuneManager;

/**
 * An action that will give the actor a random amount of runes based on the runeAmount decided in the GoldeRunes class
 *
 * @author Hayden T ran
 * @see Action
 * @see game.items.runes.GoldenRunes
 */
public class ConsumeRuneAction extends Action {

    /**
     * The item that implements the consumable interface, representing our item that is consumed for this action
     */
    private final Consumable itemToConsume;
    /**
     * The rune amount given from the itemToConsume
     */
    private final int runeAmount;

    /**
     * Constructor to instantiate the parameters given
     * @param itemToConsume
     * @param runeAmount
     */
    public ConsumeRuneAction(Consumable itemToConsume, int runeAmount) {
        this.itemToConsume = itemToConsume;
        this.runeAmount = runeAmount;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (this.itemToConsume.getCharges() > 0) {
            RuneManager.getInstance().addRunes(actor, runeAmount);
            this.itemToConsume.reduceCharges();

            return actor + " gained " + this.runeAmount + " runes. Now holding " + RuneManager.getInstance().getRunes(actor);
        } else
            return "i am cool hahaha";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Consume " + itemToConsume + " to receive a random amount of Runes";
    }


}
