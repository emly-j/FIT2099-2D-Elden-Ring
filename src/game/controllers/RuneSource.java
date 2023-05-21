package game.controllers;


/**
 * An interface for RuneSources (anything that produces/transfers runes)
 *
 * @author Emily Jap
 * @author Hayden Tran
 * @version 1.0.0
 */
public interface RuneSource {

    /**
     * Adds rune source to lists/maps in RuneManager
     *
     * @see RuneManager
     */
    void addRuneSource();
}
