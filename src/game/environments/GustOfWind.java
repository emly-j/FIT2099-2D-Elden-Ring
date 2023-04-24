package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
//import game.actors.enemies.GiantDog;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.LoneWolf;

public class GustOfWind extends SpawningGround {

    /**
     * Constructor.
     */
    public GustOfWind() {
        super('&');
        this.addActorThatSpawns(new LoneWolf(), 33);
        //this.addActorThatSpawns(new GiantDog(), 4);
    }

    @Override
    public void spawnActor(Location location) {
        NumberRange mapWidthRange = location.map().getXRange();
        boolean isWestSide = location.x() <= (mapWidthRange.max()/2);
        boolean isEastSide = location.x() > (mapWidthRange.max()/2);

        if (isWestSide) {
            location.addActor(new LoneWolf());
//        }else if (isEastSide) {
//            location.addActor(new GiantDog());
        }
    }
}

