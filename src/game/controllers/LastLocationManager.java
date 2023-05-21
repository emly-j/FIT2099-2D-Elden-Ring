package game.controllers;

import edu.monash.fit2099.engine.positions.Location;

public class LastLocationManager {

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


