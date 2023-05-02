package game.controllers;

import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that keeps track of rest location
 * @author Hayden Tran
 * @version 1.0.0
 */
public class RestLocationManager {
    private static Location lastRestedLocation;

    /**
     * stores the location at the last rested site
     * @param lastAt location of the site
     */
    public static void storeLastLocation(Location lastAt){
        lastRestedLocation = lastAt;
    }

    /**
     * static method that gets the stored location
     * @return
     */
    public static Location getLastRestedLocation(){return lastRestedLocation;}
}
