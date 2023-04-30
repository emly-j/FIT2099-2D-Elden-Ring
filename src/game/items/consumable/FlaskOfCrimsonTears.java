package game.items.consumable;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeFlaskOfCrimsonTearsAction;
import game.ResetManager;
import game.Resettable;
import game.Status;

public class FlaskOfCrimsonTears extends Item implements Resettable {

    private int charges;
    private final int MAX_USES = 2;
    public FlaskOfCrimsonTears(){
        super("Flask Of Crimson Tears", 'c', false);
        this.addAction(new ConsumeFlaskOfCrimsonTearsAction(this));
        this.charges = MAX_USES;
        ResetManager.getInstance().registerResettable(this);
    }


    public void tick(Location currentLocation, Actor actor) {
        if (this.hasCapability(Status.RESETTABLE)){
            this.charges = MAX_USES;
            this.removeCapability(Status.RESETTABLE);
            System.out.println(this + "' charges has been reset");
        }
    }
    public int decrementCharges() {
        return this.charges -= 1;
    }
    public int getCharges() {
        return charges;
    }

    @Override
    public void reset() {
        this.addCapability(Status.RESETTABLE);
    }
}
