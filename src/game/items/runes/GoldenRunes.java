package game.items.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeRuneAction;
import game.controllers.Consumable;
import game.utils.RandomNumberGenerator;

public class GoldenRunes extends Item implements Consumable {
    /***
     * Constructor.
     */

    private int charges;

    private final int value;

    public GoldenRunes() {
        super("Golden Rune", '*', true);
        this.value = RandomNumberGenerator.getRandomInt(200, 10000);
        this.charges = 1;

    }

    public void tick(Location currentLocation, Actor actor) {
        if (this.charges == 0) {
            actor.removeItemFromInventory(this);
        }
        if (actor.getItemInventory().contains(this)) {
            this.addAction(new ConsumeRuneAction(this, value));
        }
    }

    @Override
    public int getCharges() {
        return this.charges;
    }

    @Override
    public void reduceCharges() {
        this.charges -= 1;

    }

    @Override
    public String chargesString() {
        return null;
    }

}
