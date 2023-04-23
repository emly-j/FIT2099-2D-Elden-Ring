package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.SkeletalBandit;
import game.actors.enemies.Skeleton;

public class Graveyard extends SpawningGround {

    /**
     * Constructor.
     */
    public Graveyard() {
        super('n');
        this.addActorThatSpawns(new HeavySkeletalSwordsman(), 27);
        this.addActorThatSpawns(new SkeletalBandit(), 27);
    }
}

