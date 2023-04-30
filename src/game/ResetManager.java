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
    /**
     * we create a list of resettable instances here (players, items, runes)
     */
    private List<Resettable> resettables;
    private static ResetManager instance;

    /**
     * HINT 1: where have we seen a private constructor before?
     * HINT 2: see the instance attribute above.
     */
    private ResetManager() { //we saw this used in purchase manager
        this.resettables = new ArrayList<>();
    }

    /**
     * gets single instance of reset amanger
     * @return returns single instant of reset manager
     */
    public static ResetManager getInstance(){
        if (instance == null) {
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * resets the game by going through all resettable objects in the list
     */
    public void runReset() {
        for (Resettable object : this.resettables){
            object.reset();
        }
    }

    /**
     * adds the instance of resttable to the list
     * @param resettable
     */
    public void registerResettable(Resettable resettable) {
        this.resettables.add(resettable);
    }

    /**
     * remove the resttable instance from the list
     * @param resettable
     */
    public void removeResettable(Resettable resettable) {
        this.resettables.remove(resettable);
    }
}
