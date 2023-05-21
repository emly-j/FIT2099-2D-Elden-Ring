package game.controllers;

/**
 * A interface the represents all items that will be used to consume
 *
 * @author Hayden
 * @version 1.0.0
 */
public interface Consumable {
    /**
     * To get the amount of uses left
     *
     * @return
     */
    int getCharges();

    /**
     * To decrement the uses after using
     */
    void reduceCharges();

    /**
     * representing the string that can later be called in the ConsumeAction
     *
     * @return
     */
    String chargesString();

}
