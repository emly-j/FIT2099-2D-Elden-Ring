package game.items.consumable;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeFlaskOfCrimsonTearsAction;
import game.ResetManager;
import game.Resettable;
import game.Status;

/**
 * Class that represents the FLash of Crimson Tears item for our current implementation
 * @author Hayden Tran
 * @version 1.0.0
 */
public class FlaskOfCrimsonTears extends Item implements Resettable {
    /**
     * The amount of charges the item will have to use
     */
    private int charges;
    /**
     * The maximum amount of charges in our current implementation
     */
    private final int MAX_USES = 2;

    /**
     * Constructor that instantiates the item and adds the action and registers it as an instance of resettable
     */
    public FlaskOfCrimsonTears(){
        super("Flask Of Crimson Tears", 'c', false);
        this.addAction(new ConsumeFlaskOfCrimsonTearsAction(this));
        this.charges = MAX_USES;
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Updated the tick method so that whenever the reset() method is called, the item will reset its charges
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    public void tick(Location currentLocation, Actor actor) {
        if (this.hasCapability(Status.RESETTABLE)){
            this.charges = MAX_USES;
            this.removeCapability(Status.RESETTABLE);
            System.out.println(this + "' charges has been reset");
        }
    }

    /**
     * Whenever item is used, will decrement the charge
     * @return
     */
    public int decrementCharges() {
        return this.charges -= 1;
    }

    /**
     * return the amount of charges for user
     * @return
     */
    public int getCharges() {
        return charges;
    }


    /**
     * When reset is called, will add capability Resettable
     */
    @Override
    public void reset() {
        this.addCapability(Status.RESETTABLE);
    }
}
