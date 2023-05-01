package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.SkeletalBandit;

/**
 * Class that represents the Graveyard class and can spawn the HeavySkeletalSwordsman and SkeletalBandit
 * @author Emily Jap
 * @version 1.0.0
 */
public class Graveyard extends SpawningGround {

    /**
     * Constructor that instaniates the ground and indicates which actors can be added with their spawn chance
     */
    public Graveyard() {
        super('n');
        this.addActorThatSpawns(new HeavySkeletalSwordsman(), 27);
        this.addActorThatSpawns(new SkeletalBandit(), 27);
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
            location.addActor(new HeavySkeletalSwordsman());
        }else if (isEastSide) {
            location.addActor(new SkeletalBandit());
        }
    }
}

