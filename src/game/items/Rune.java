package game.items;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.Resettable;
import game.Status;
import game.actions.RetrieveAction;
import game.actions.RetrieveRuneAction;
import game.actors.Player;

public class Rune extends Item implements Resettable {
    private int value;
    private int counter;
    private Actor player;


    /***
     * Constructor.
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
     * @param currentLocation The location of the ground on which we lie.
     */
    public void tick(Location currentLocation) {
        if (this.hasCapability(Status.RESETTABLE)){ //if resettable, remove the item
            currentLocation.removeItem(this);
            System.out.println("Runes reset");
        }

        if (currentLocation.containsAnActor() && !currentLocation.getActor().hasCapability(Status.CAN_RETRIEVE)){
            currentLocation.getActor().addCapability(Status.CAN_RETRIEVE);
            System.out.println("ACTOR CAN NOW RETRIEVE");
            addAction(this.getRetrieveAction(currentLocation.getActor()));
        }
    }

    public int getValue(){
        return value;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public RetrieveAction getRetrieveAction(Actor actor) {
        return new RetrieveRuneAction(this);
    }

    @Override
    public void reset() {

        if (this.player.hasCapability(Status.PLAYERDIEDTWICE)) {
            System.out.println("PLAYEER DIED TWICE CHECK");
            this.counter -= 1;
        }

        if (this.counter == 0){
            System.out.println("RUNE COUNTER " + this.counter);
            this.addCapability(Status.RESETTABLE);
            System.out.println("RUNES ARE NOW RESETTABLE");
        }
    }
}