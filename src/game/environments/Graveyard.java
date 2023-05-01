package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.LoneWolf;
//import game.actors.enemies.SkeletalBandit;
import game.actors.enemies.Skeleton;

public class Graveyard extends SpawningGround {

    /**
     * Constructor.
     */
    public Graveyard() {
        super('n');
        this.addActorThatSpawns(new HeavySkeletalSwordsman(), 27);
        //this.addActorThatSpawns(new SkeletalBandit(), 27);
    }

    @Override
    public void spawnActor(Location location) {
        NumberRange mapWidthRange = location.map().getXRange();
        boolean isWestSide = location.x() <= (mapWidthRange.max()/2);
        boolean isEastSide = location.x() > (mapWidthRange.max()/2);

        if (isWestSide) {
            location.addActor(new HeavySkeletalSwordsman());
//        }else if (isEastSide) {
//            location.addActor(new SkeletalBandit());
        }
    }
}

