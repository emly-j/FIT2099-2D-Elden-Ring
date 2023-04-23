package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.actors.enemies.GiantDog;
import game.actors.enemies.LoneWolf;

public class GustOfWind extends SpawningGround {

    /**
     * Constructor.
     */
    public GustOfWind() {
        super('&');
        this.addActorThatSpawns(new LoneWolf(), 33);
        this.addActorThatSpawns(new GiantDog(), 4);
    }
}

