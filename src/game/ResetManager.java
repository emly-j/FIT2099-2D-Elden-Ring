package game;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager {
    private List<Resettable> resettables;
    private static ResetManager instance;

    /**
     * HINT 1: where have we seen a private constructor before?
     * HINT 2: see the instance attribute above.
     */

    /**
     * gets the instance of reset manager
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }

    public static ResetManager getInstance(){
        if (instance == null) {
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * resets game by going through all resettable objects in the list
     */
    public void run() {
        for (Resettable object : this.resettables){
            object.reset();
        }
    }

    /**
     * adds resettable instance to the list
     * @param resettable
     */
    public void registerResettable(Resettable resettable) {
        this.resettables.add(resettable);
    }

    /**
     * remove resettable instance from the list
     * @param resettable
     */
    public void removeResettable(Resettable resettable) {
        this.resettables.remove(resettable);
    }
}
