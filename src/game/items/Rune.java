package game.items;


import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Resettable;

public class Rune extends Item implements Resettable {
    private int value;


    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Rune(String name, char displayChar, boolean portable, int value) {
        super("rune", '$', true);
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public void tick(Location currentLocation) {

    }

    @Override
    public void reset() {

    }



}
