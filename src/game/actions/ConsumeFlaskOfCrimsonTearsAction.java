package game.actions;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.consumable.FlaskOfCrimsonTears;

/**
 * action executed when an item is consumed
 * Created by:
 * @author Hayden Tran
 *
 */
public class ConsumeFlaskOfCrimsonTearsAction extends Action {
    private final FlaskOfCrimsonTears flaskOfCrimsonTears;

    /**
     *
     * @param flaskOfCrimsonTears
     */
    public ConsumeFlaskOfCrimsonTearsAction(FlaskOfCrimsonTears flaskOfCrimsonTears) {
        this.flaskOfCrimsonTears = flaskOfCrimsonTears;

    }


    /**
     * When executed, increase player health using the heal method
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (flaskOfCrimsonTears.getCharges() > 0) {
            actor.heal(250);
            flaskOfCrimsonTears.decrementCharges();
            return actor + " healed for 250 HP";
        } else {
            return "Tried to heal but failed.";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        if (flaskOfCrimsonTears.getCharges() > 0){
            return "Use the Flask of Crimson Tears (" + flaskOfCrimsonTears.getCharges() + "/2)";
        } else {
            return "No remaining charges of Flask Of Crimson Tears";
        }
    }
}
