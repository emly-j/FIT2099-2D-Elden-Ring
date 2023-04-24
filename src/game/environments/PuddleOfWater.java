package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.GiantCrab;
//import game.actors.enemies.GiantCrayfish;

public class PuddleOfWater extends SpawningGround {

    /**
     * Constructor.
     */
    public PuddleOfWater() {
        super('~');
        this.addActorThatSpawns(new GiantCrab(), 2);
        //this.addActorThatSpawns(new GiantCrayfish(), 1);
    }

    @Override
    public void spawnActor(Location location) {
        NumberRange mapWidthRange = location.map().getXRange();
        boolean isWestSide = location.x() <= (mapWidthRange.max()/2);
        boolean isEastSide = location.x() > (mapWidthRange.max()/2);

        if (isWestSide) {
            location.addActor(new GiantCrab());
//        }else if (isEastSide) {
//            location.addActor(new GiantCrayfish());
        }
    }
}
