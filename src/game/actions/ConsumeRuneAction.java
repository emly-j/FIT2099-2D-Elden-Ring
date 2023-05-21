package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.controllers.Consumable;
import game.controllers.RuneManager;

public class ConsumeRuneAction extends Action {
    /**
     * Constructor which takes in these parameters to determine which item to consume and how much to heal
     *
     * @param itemToConsume
     * @param heal
     */

    private final Consumable itemToConsume;
    private final int runeAmount;

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
