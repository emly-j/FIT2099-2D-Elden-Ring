package game.environments.spawning;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.soldiers.GodrickSoldier;
import game.utils.RandomNumberGenerator;

public class Barrack extends SpawningGround {
    /**
     * Constructor.
     */
    public Barrack() {
        super('B');
        this.addActorThatSpawns(new GodrickSoldier(), 45);
    }

    /**
     * A factory method to spawn actors depending on their chance of spawning and the location on the map.
     *
     * @param actor    actor that may potentially spawn
     * @param location location where the actor will spawn
     */
    @Override
    public void spawnActor(Actor actor, Location location) {
        boolean canSpawn = RandomNumberGenerator.getRandomChance(getActorSpawnChance(actor));

        if(canSpawn){
            location.addActor(new GodrickSoldier());
        }
    }
}
