package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Sellable;
import game.utils.Status;

public class Scimitar extends WeaponItem implements Sellable {
    /***
     * Constructor.
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

    public void sellItem(Actor actor) {

    }

}
