package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.GiantCrayfish;

public class PuddleOfWater extends SpawningGround {

    /**
     * Constructor.
     */
    public PuddleOfWater() {
        super('~');
        this.addActorThatSpawns(new GiantCrab(), 2);
        this.addActorThatSpawns(new GiantCrayfish(), 1);
    }
}
