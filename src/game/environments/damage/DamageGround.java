package game.environments.damage;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * An abstract ground class for grounds that damage actors standing on top of it
 *
 * @author Emily Jap
 * @version 1.0.0
 */
public abstract class DamageGround extends Ground {

    /**
     * The amount of damage done by this ground
     */
    private final int damage;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public DamageGround(char displayChar, int damage) {
        super(displayChar);
        this.damage = damage;
    }

    /**
     * Returns the amount of damage done by the ground
     *
     * @return
     */
    public int getDamage() {
        return damage;
    }

    @Override
    public void tick(Location location) {
        // if there is an actor on this ground, deal damage
        if (location.containsAnActor()) {
            Actor actor = location.getActor();
            actor.hurt(damage);
        }
    }
}
