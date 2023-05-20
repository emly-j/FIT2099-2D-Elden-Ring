package game.environments.spawn;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.canine.Dog;
import game.actors.enemies.canine.GiantDog;
import game.actors.enemies.crustacean.GiantCrayfish;
import game.actors.enemies.dragon.LesserDragon;
import game.actors.enemies.skeleton.SkeletalBandit;
import game.actors.enemies.soldiers.GodrickSoldier;
import game.utils.RandomNumberGenerator;

/**
 * A class for spawning enemies on the east side of the map
 * @author Emily Jap
 * @version 1.0.0
 */
public class EastFactory implements EnemyFactory{

    /**
     * Checks if a given location is on the east side of the map
     * @param location location we are checking the side of on the map
     * @return boolean
     */
    private boolean isEastSide(Location location){
        NumberRange mapWidthRange = location.map().getXRange();
        return location.x() > (mapWidthRange.max()/2);
    }

    /**
     * A method for creating canine type enemies
     *
     * @param location
     */
    @Override
    public void spawnCanine(Location location) {
        if (RandomNumberGenerator.getRandomChance(4) && isEastSide(location)) {
            location.addActor(new GiantDog());
        }
    }

    /**
     * A method for creating crustacean type enemies
     *
     * @param location
     */
    @Override
    public void spawnCrustacean(Location location) {
        if (RandomNumberGenerator.getRandomChance(1) && isEastSide(location)) {
            location.addActor(new GiantCrayfish());
        }
    }

    /**
     * A method for creating skeletal type enemies
     *
     * @param location
     */
    @Override
    public void spawnSkeleton(Location location) {
        if (RandomNumberGenerator.getRandomChance(27) && isEastSide(location)){
            location.addActor(new SkeletalBandit());
        }
    }

    /**
     * A method for creating dragon type enemies
     *
     * @param location location where the enemy will spawn
     */
    @Override
    public void spawnDragon(Location location) {
        if (RandomNumberGenerator.getRandomChance(10) && isEastSide(location)){
            location.addActor(new LesserDragon());
        }
    }

    /**
     * A method for creating Dog enemies
     *
     * @param location location where the enemy will spawn
     */
    @Override
    public void spawnDog(Location location) {
        if (RandomNumberGenerator.getRandomChance(37) && isEastSide(location)){
            location.addActor(new Dog());
        }
    }

    /**
     * A method for creating Soldier enemies
     *
     * @param location location where the enemy will spawn
     */
    @Override
    public void spawnSoldier(Location location) {
        if (RandomNumberGenerator.getRandomChance(45) && isEastSide(location)){
            location.addActor(new GodrickSoldier());
        }
    }


}
