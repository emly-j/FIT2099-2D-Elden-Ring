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
 *
 */
public class Player extends Actor implements Resettable, RuneSource {
	private final Menu menu = new Menu();



	private int respawnX;
	private int respawnY;


	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		super.printHp();
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addWeaponToInventory(new Club());
		ResetManager.getInstance().registerResettable(this);
		addRuneSource();
		System.out.println(RuneManager.getInstance().getRunes(this));
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		System.out.println("(" + this.getHealth() + "/" + this.maxHitPoints + ")");
		System.out.println(RuneManager.getInstance().getRunes(this));
		System.out.println(this.hasCapability(Status.RESTED));

//		if (!this.isConscious()){
//			map.moveActor(this, map.at(respawnX, respawnY));
//			System.out.println("concious checker");
//		}

//		if (this.hasCapability(Status.RESTED)){
//			this.respawnX = map.locationOf(this).x();
//			this.respawnY = map.locationOf(this).y();
//			this.removeCapability(Status.RESTED);
//			System.out.println("rested capcabilit checker");
//		}
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

	public int getHealth(){
		return this.hitPoints;
	}

	public int getRespawnX(){
		return this.getRespawnX();
	}

	public int getRespawnY(){
		return this.getRespawnY();
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
		RuneManager.getInstance().addRunes(this, 0);
	}

}


//			if (this.hitPoints <= 0){
//				RuneFloor droppedRune = new RuneFloor(); // create new runefloor to hold the runes from our player when we die
//				RuneManager.getInstance().addRunes(droppedRune, RuneManager.getInstance().getRunes((RuneSource) this)); //update the amount of runes that player has to be the floor has
//				map.at(map.locationOf(this).x(), map.locationOf(this).y()).setGround(droppedRune); //setground to the runefloor at location of the player
//				RuneManager.getInstance().subtractRunes((RuneSource) this, RuneManager.getInstance().getRunes((RuneSource) this)); // subtract all the runes of player to = 0
//				map.moveActor(this, map.at(21, 30)); //when die, want to move them to coords of siteoflostgrace
//				System.out.println("resetter worker");
//
//			}
//			RuneFloor droppedRune = new RuneFloor();
//			RuneManager.getInstance().addRunes(droppedRune, RuneManager4
//			.getInstance().getRunes(this));
//			Location hi = new Location(map, 36, 10);
//			hi.setGround(droppedRune);
//			map.at(36,10).setGround(droppedRune);
//			RuneManager.getInstance().subtractRunes(this, RuneManager.getInstance().getRunes(this));
//			map.locationOf(this);

