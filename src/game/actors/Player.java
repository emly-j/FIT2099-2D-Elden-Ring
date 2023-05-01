package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.ResetManager;
import game.RuneManager;
import game.Resettable;
import game.RuneSource;
import game.Status;
import game.items.weapons.Club;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Hayden Tran
 * @author Emily Jap
 * @version 1.0.0

 */
public class Player extends Actor implements Resettable, RuneSource {
	private final Menu menu = new Menu();

	private int respawnX;
	private int respawnY;


	/**
	 * Constructor that instantiates the player, registering it as a resettable instance, making it capable of holding runes
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addWeaponToInventory(new Club());
		ResetManager.getInstance().registerResettable(this);
		addRuneSource();
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		System.out.println("(" + this.getHealth() + "/" + this.maxHitPoints + ")");
		System.out.println(this + " has: " + RuneManager.getInstance().getRunes(this) + " runes");



		// Handle multi-turn Actions
		if (this.hasCapability(Status.RESETTABLE)){
			this.removeCapability(Status.RESETTABLE);
			System.out.println(this + " has been reset");

		}
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	/**
	 * Used to get the current health of player
	 * @return current health
	 */
	public int getHealth(){
		return this.hitPoints;
	}


	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(11, "punches", 100);
	}

	@Override
	public void reset() {
		this.addCapability(Status.RESETTABLE);
		this.hitPoints = maxHitPoints;
	}

	@Override
	public void addRuneSource() {
		RuneManager.getInstance().addRuneOwner(this, 0);
	}

}

