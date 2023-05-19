package game.environments.spawning;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.canine.Dog;
import game.actors.enemies.canine.GiantDog;
import game.actors.enemies.canine.LoneWolf;
import game.actors.enemies.crustacean.GiantCrab;
import game.actors.enemies.crustacean.GiantCrayfish;
import game.actors.enemies.dragons.LesserDragon;
import game.actors.enemies.skeleton.HeavySkeletalSwordsman;
import game.actors.enemies.skeleton.SkeletalBandit;
import game.actors.enemies.soldiers.GodrickSoldier;
import game.utils.RandomNumberGenerator;

public class WestFactory implements EnemyFactory{

    /**
     * Checks if a given location is on the west side of the map
     * @param location location we are checking the side of on the map
     * @return boolean
     */
    private boolean isWestSide(Location location){
        NumberRange mapWidthRange = location.map().getXRange();
        return location.x() <= (mapWidthRange.max()/2);
    }

    /**
     * A method for creating canine type enemies
     *
     * @param location
     */
    @Override
    public void spawnCanine(Location location) {
        if (RandomNumberGenerator.getRandomChance(33) && isWestSide(location)){
            location.addActor(new LoneWolf());
        }
    }

    /**
     * A method for creating crustacean type enemies
     *
     * @param location
     */
    @Override
    public void spawnCrustacean(Location location) {
        if (RandomNumberGenerator.getRandomChance(2) && isWestSide(location)){
            location.addActor(new GiantCrab());
        }
    }

    /**
     * A method for creating skeletal type enemies
     *
     * @param location
     */
    @Override
    public void spawnSkeleton(Location location) {
        if (RandomNumberGenerator.getRandomChance(27) && isWestSide(location)){
            location.addActor(new HeavySkeletalSwordsman());
        }
    }

    /**
     * A method for creating dragon type enemies
     *
     * @param location location where the enemy will spawn
     */
    @Override
    public void spawnDragon(Location location) {
        if (RandomNumberGenerator.getRandomChance(10) && isWestSide(location)){
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
        if (RandomNumberGenerator.getRandomChance(37) && isWestSide(location)){
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
        if (RandomNumberGenerator.getRandomChance(45) && isWestSide(location)){
            location.addActor(new GodrickSoldier());
        }
    }
}
