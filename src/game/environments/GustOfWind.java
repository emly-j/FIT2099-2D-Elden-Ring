package game.environments;

import game.actors.enemies.GiantDog;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.LoneWolf;

/**
 * Class that represents the GustofWind location which can spawn the LoneWolf and GiantDog
 * @author Emily Jap
 * @version 1.0.0
 */
public class GustOfWind extends SpawningGround {

    /**
     * Constructor that instantiates the ground and adds the actors which can spawn with their spawn chance
     */
    public GustOfWind() {
        super('&');
        this.addActorThatSpawns(new LoneWolf(), 33);
        this.addActorThatSpawns(new GiantDog(), 4);
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
            location.addActor(new LoneWolf());
        }else if (isEastSide) {
            location.addActor(new GiantDog());
        }
    }
}

