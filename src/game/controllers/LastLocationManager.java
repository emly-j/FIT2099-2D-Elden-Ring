package game.controllers;

import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that will store the last location so that when a player dies, their items will drop on the previous location
 *
 * @author Hayden Tran
 * @version 1.0.0
 * @see game.actions.DeathAction
 */
public class LastLocationManager {

    /**
     * A static location instance to be accessed anywhere
     */
    private static Location lastLocation;

    /**
     * stores the location at the last rested site
     *
     * @param lastAt location of the site
     */
    public static void storeLastLocation(Location lastAt) {
        lastLocation = lastAt;
    }

    /**
     * static method that gets the stored location
     *
     * @return
     */
    public static Location getLastLocation() {
        return lastLocation;
    }
}


