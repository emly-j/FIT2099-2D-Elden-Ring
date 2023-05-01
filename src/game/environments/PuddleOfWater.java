package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.GiantCrayfish;

/**
 * A class which represents the PuddleOfWater that spawns GiantCrabs and GiantCrayfish
 * @author Emily Jap
 * @version 1.0.0
 */
public class PuddleOfWater extends SpawningGround {

    /**
     * Constructor that instaniates the ground and indicates which actors can be added with their spawn chance
     */
    public PuddleOfWater() {
        super('~');
        this.addActorThatSpawns(new GiantCrab(), 2);
        this.addActorThatSpawns(new GiantCrayfish(), 1);
    }

    /**
     * Overwritting the spawnactor method that checks which side of the map is on and spawns the corressponding actor after
     * @see SpawningGround tick() method
     * @param location
     */
    @Override
    public void spawnActor(Location location) {
        NumberRange mapWidthRange = location.map().getXRange();
        boolean isWestSide = location.x() <= (mapWidthRange.max()/2);
        boolean isEastSide = location.x() > (mapWidthRange.max()/2);

        if (isWestSide) {
            location.addActor(new GiantCrab());
        }else if (isEastSide) {
            location.addActor(new GiantCrayfish());
        }
    }
}
