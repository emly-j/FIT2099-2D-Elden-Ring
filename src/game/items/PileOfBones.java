package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.actions.BreakAction;
import game.actors.AttackType;

public class PileOfBones extends Item implements Breakable{

    private Actor revivableActor;
    private Location location;
    private int counter;

    /***
     * Constructor.
     */
    public PileOfBones(Actor revivableActor, Location location) {
        super("Pile Of Bones", 'X', false);
        this.revivableActor = revivableActor;
        this.location = location;
        addAction(new BreakAction(this, location));
        addCapability(AttackType.CANNOT_ATTACK_SKELETONS);
        counter = 0;
    }

    @Override
    public String broken(Actor by, Location at) {
        // drop weapon if player breaks bones
        Location location = at;
        Actor actor = by;
        WeaponItem weaponDropped = revivableActor.getWeaponInventory().get(0); // we assume the first weapon is a grossmesser/scimitar
        // TODO: Implement runes transfer
        String resultString = "Pile of Bones was broken by " + actor + " at " + location;

        location.removeItem(this);
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            location.addItem(weaponDropped);
            resultString += " and a " + weaponDropped + " was dropped.";
        }

        return resultString;
    }

    @Override
    public Action getBreakAction() {
        return new BreakAction(this, location);
    }

    @Override
    public void tick(Location currentLocation) {
        counter += 1;

        if (counter == 3){
            // revive
            currentLocation.removeItem(this);
            currentLocation.addActor(revivableActor);
        }
    }
}
