package game.items;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.controllers.Resettable;
import game.controllers.ResetManager;
import game.actions.RetrieveAction;
import game.actions.RetrieveRuneAction;
import game.utils.Status;


/**
 * Rune class represents a generic Rune which will be on the floor, mainly used for the Death Action, RetrieveRuneAction
 * @author Hayden Tran
 * @version 1.0.0
 */
public class Rune extends Item implements Resettable {
    /**
     * How much the rune holds
     */
    private int value;
    /**
     * Counter to decrement when (so that runes despawn after a turn)
     */
    private int counter;
    /**
     * instance of player to dedicate the rune to
     */
    private Actor player;


    /**
     * Constructor for Rune class
     * @param value value of device
     * @param player player that the rune is linked to
     */
    public Rune(int value, Actor player) {
        super("Rune", '$', false);
        this.value = value;
        this.player = player;
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Inform an Item on the ground of the passage of time.
     * This method is called once per turn, if the item rests upon the ground.
     * If has capability resettable, the item will be removed from the ground
     * If an actor is on the item and doesnt have the CAN_RETRIEVE capability, will add the getRetrieveAction
     * @param currentLocation The location of the ground on which we lie.
     */
    public void tick(Location currentLocation) {
        Display display = new Display();

        if (this.hasCapability(Status.RESETTABLE)){ //if resettable, remove the item
            currentLocation.removeItem(this);
            display.println("Runes reset");
        }

        if (currentLocation.containsAnActor() && !currentLocation.getActor().hasCapability(Status.CAN_RETRIEVE)){
            currentLocation.getActor().addCapability(Status.CAN_RETRIEVE);
            display.println("ACTOR CAN NOW RETRIEVE");
            addAction(this.getRetrieveAction(currentLocation.getActor()));
        }
    }

    /**
     * getter for value
     * @return the value as an integer
     */
    public int getValue(){
        return value;
    }

    /**
     * setter for counter
     * @param counter when called will update the counter
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * When called will give the RetrieveRuneAction to the actor
     * @param actor
     * @return
     */
    public RetrieveAction getRetrieveAction(Actor actor) {
        return new RetrieveRuneAction(this);
    }

    /**
     * Counter decrements when player has Status.PLAYERDIEDTWICE
     * @see game.actions.DeathAction
     */
    @Override
    public void reset() {
        Display display = new Display();

        if (this.player.hasCapability(Status.PLAYERDIEDTWICE)) {
            display.println("PLAYEER DIED TWICE CHECK");
            this.counter -= 1;
        }

        if (this.counter == 0){
            display.println("RUNE COUNTER " + this.counter);
            this.addCapability(Status.RESETTABLE);
            display.println("RUNES ARE NOW RESETTABLE");
        }
    }
}