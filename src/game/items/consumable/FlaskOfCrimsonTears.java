package game.items.consumable;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.controllers.Consumable;
import game.controllers.ResetManager;
import game.controllers.Resettable;
import game.utils.Status;

/**
 * Class that represents the FLash of Crimson Tears item for our current implementation
 *
 * @author Hayden Tran
 * @version 1.0.0
 */
public class FlaskOfCrimsonTears extends Item implements Resettable, Consumable {
    /**
     * The amount of charges the item will have to use
     */
    private int charges;
    /**
     * The maximum amount of charges in our current implementation
     */
    private final int MAX_USES = 2;
    private final int health = 250;

    /**
     * Constructor that instantiates the item and adds the action and registers it as an instance of resettable
     */
    public FlaskOfCrimsonTears() {
        super("Flask Of Crimson Tears", 'c', false);
        this.addAction(new ConsumeAction(this, health));
        this.charges = MAX_USES;
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Updated the tick method so that whenever the reset() method is called, the item will reset its charges
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor           The actor carrying this Item.
     */
    public void tick(Location currentLocation, Actor actor) {
        if (this.hasCapability(Status.RESETTABLE)) {
            this.charges = MAX_USES;
            this.removeCapability(Status.RESETTABLE);
            Display display = new Display();
            display.println(this + "' charges has been reset");
        }
    }

    @Override
    public int getCharges() {
        return charges;
    }

    @Override
    public void reduceCharges() {
        this.charges -= 1;
    }

    @Override
    public String chargesString() {
        return " (" + getCharges() + "/" + this.MAX_USES + ")";
    }


    /**
     * When reset is called, will add capability Resettable
     */
    @Override
    public void reset() {
        this.addCapability(Status.RESETTABLE);
    }
}
