//package game.actors;
//
//import edu.monash.fit2099.engine.actions.Action;
//import edu.monash.fit2099.engine.actions.ActionList;
//import edu.monash.fit2099.engine.actors.Actor;
//import edu.monash.fit2099.engine.displays.Display;
//import edu.monash.fit2099.engine.positions.GameMap;
//import game.Status;
//
//public class MerchantKale extends Actor {
//
//    public MerchantKale(){
//        super("Merchant Kale", 'K', 10000)
//    }
//
//
//    /**
//     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
//     *
//     * @param otherActor the Actor that might be performing attack
//     * @param direction  String representing the direction of the other Actor
//     * @param map        current GameMap
//     * @return A collection of Actions.
//     */
//    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
//        ActionList actions = new ActionList();
//        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
//            actions.add(new buy)
//        }
//
//
//        return new ActionList();
//    }
//
//    @Override
//    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
//        return null;
//    }
//}
