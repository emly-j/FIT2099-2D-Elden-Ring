package game.environments.spawningenvironments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.crustacean.GiantCrab;
import game.actors.enemies.crustacean.GiantCrayfish;
import game.utils.RandomNumberGenerator;

/**
 * A class which represents the PuddleOfWater SpawningGround that spawns GiantCrabs and GiantCrayfish
 * @author Emily Jap
 * @version 1.0.0
 * @see SpawningGround
 */
public class PuddleOfWater extends SpawningGround {

    /**
     * Constructor that instantiates the ground and adds actors that can be added with their spawn chance
     */
    public PuddleOfWater() {
        super('~');
        this.addActorThatSpawns(new GiantCrab(), 2);
        this.addActorThatSpawns(new GiantCrayfish(), 1);
    }

    @Override
    public void spawnActor(Actor actor, Location location) {
        NumberRange mapWidthRange = location.map().getXRange();
        boolean isWestSide = location.x() <= (mapWidthRange.max()/2);
        boolean isEastSide = location.x() > (mapWidthRange.max()/2);

        boolean canSpawn = RandomNumberGenerator.getRandomChance(getActorSpawnChance(actor));

        if (isWestSide && canSpawn) {
            location.addActor(new GiantCrab());
        }else if (isEastSide && canSpawn) {
            location.addActor(new GiantCrayfish());
        }
    }
}
