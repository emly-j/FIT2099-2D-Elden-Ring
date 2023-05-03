package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.GiantCrayfish;
import game.actors.enemies.GiantDog;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.LoneWolf;
import game.utils.RandomNumberGenerator;

/**
 * Class that represents the GustofWind SpawningGround which can spawn the LoneWolf and GiantDog
 * @author Emily Jap
 * @version 1.0.0
 * @see SpawningGround
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

    @Override
    public void spawnActor(Actor actor, Location location) {
        NumberRange mapWidthRange = location.map().getXRange();
        boolean isWestSide = location.x() <= (mapWidthRange.max()/2);
        boolean isEastSide = location.x() > (mapWidthRange.max()/2);

        int actorSpawnChance = getActorsThatSpawn().get(actor);
        boolean canSpawn = RandomNumberGenerator.getRandomChance(actorSpawnChance);

        if (isWestSide && canSpawn) {
            location.addActor(new LoneWolf());
        }else if (isEastSide && canSpawn) {
            location.addActor(new GiantDog());
        }
    }
}

