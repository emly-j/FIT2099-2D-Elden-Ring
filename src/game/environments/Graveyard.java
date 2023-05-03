package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.GiantCrayfish;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.LoneWolf;
//import game.actors.enemies.SkeletalBandit;
import game.actors.enemies.SkeletalBandit;
import game.actors.enemies.Skeleton;
import game.utils.RandomNumberGenerator;

/**
 * Class that represents the Graveyard SpawningGround which can spawn the HeavySkeletalSwordsman and SkeletalBandit
 * @author Emily Jap
 * @version 1.0.0
 * @see SpawningGround
 */
public class Graveyard extends SpawningGround {

    /**
     * Constructor that instantiates the ground and adds actors that can be added with their spawn chance.
     */
    public Graveyard() {
        super('n');
        this.addActorThatSpawns(new HeavySkeletalSwordsman(), 27);
        this.addActorThatSpawns(new SkeletalBandit(), 27);
    }

    @Override
    public void spawnActor(Actor actor, Location location) {
        NumberRange mapWidthRange = location.map().getXRange();
        boolean isWestSide = location.x() <= (mapWidthRange.max()/2);
        boolean isEastSide = location.x() > (mapWidthRange.max()/2);

        int actorSpawnChance = getActorsThatSpawn().get(actor);
        boolean canSpawn = RandomNumberGenerator.getRandomChance(actorSpawnChance);

        if (isWestSide && canSpawn) {
            location.addActor(new HeavySkeletalSwordsman());
        }else if (isEastSide && canSpawn) {
            location.addActor(new SkeletalBandit());
        }
    }
}

