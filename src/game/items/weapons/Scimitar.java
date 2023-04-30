package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.items.Sellable;

public class Scimitar extends WeaponItem implements Sellable {
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "schiing", 88);
        this.addCapability(Status.PERFORM_AREA_ATTACK);
    }

    @Override
    public Action getSkill(Actor target, String direction){
        return null;
    }

    @Override
    public int getSellPrice() {
        return 100;
    }

    @Override
    public void sellItem(Actor actor) {

    }

}
