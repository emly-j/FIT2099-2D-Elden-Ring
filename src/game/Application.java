package game;

import game.actors.enemies.canine.LoneWolf;
import game.actors.traders.FingerReaderEnia;
import game.environments.spawn.Barrack;
import game.environments.spawn.Cage;
import game.environments.spawn.Dragonbarrow;
import game.environments.spawn.Graveyard;
import game.environments.spawn.GustOfWind;
import game.environments.spawn.PuddleOfWater;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.*;
import game.actors.traders.MerchantK;
import game.actors.Player;
import game.controllers.RestLocationManager;
import game.environments.*;
import game.environments.sitesoflostgrace.TheFirstStep;
import game.items.RemembranceOfTheGrafted;
import game.utils.FancyMessage;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Emily Jap
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(), new GustOfWind(), new PuddleOfWater(), new Cliff(), new Dragonbarrow(), new Cage());

		List<String> map1 = Arrays.asList(
				"......................#.............#..........................+++.........", // x = 30, y = 0
				"......................#.............#.......................+++++..........",
				"......................#..___....____#.........................+++++........",
				"......................#...........__#............................++........",
				"......................#_____........#.............................+++......",
				"......................#............_#..............................+++.....",
				"......................######___######......................................",
				"...........................................................................",
				"..........................._...............................................",
				"........++++......................###___###................................",
				"........+++++++...................________#................................",
				"..........+++.....................#________................................",
				"............+++...................#_______#................................",
				".............+....................###___###................................",
				"............++......................#___#..................................",
				"..............+..................._........................................",
				"..............++................................................._.........",
				"..............................................++...........................",
				"..................++++......................+++...............######..##...",
				"#####___######....++...........................+++............#....____....",
				"_____________#.....++++.............rrrr.........+..............__.....#...",
				"_____________#.....+....++........................++.........._.....__.#...",
				"_____________#.........+..+.....................+++...........###..__###...",
				"_____________#.............++.............................................."); /// x = 6 y = 24

//				"..nnnn................................................~~~~~~~~~~~~~~~~~~~~~",
//				"......................#####....######..................~~~~~~~~~~~~~~~~~~~~",
//				"..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~",
//				"..................................__#....................~~~~~~~~~~~~~~~~~~",
//				"......................._____........#.....................~~~~~~~~~~~~~~~~~",
//				"......................#............_#......................~~~~~~~~~~~~~~~~",
//				"......................#...........###......................................",
//				"...........................................................................",
//				"...........................................................................",
//				"~~~~~~~~~~~.......................###___###................................",
//				"~~~~~~~~~~~~......................________#....nnnn........................",
//				"~~~~~~~~~~~~~.....................#________................................",
//				"~~~~~~~~~~~~......................#_______#....nnnn........................",
//				"~~~~~~~~~~~.......................###___###................................",
//				"~~~~~~~~~~..........................#___#..................................",
//				"...........................................................................",
//				"...........................................................................",
//				"...........................................................................",
//				"..####__##...........................................&&&......######..##...",
//				"..#.....__...........................................&&&......#....____....",
//				"..#___..............&&&..............................&&&........__.....#...",
//				"..####__###.........&&&......................................._.....__.#...",
//				"....................&&&.......................................###..__###...",
//				"...........................................................................");
		GameMap initialMap = new GameMap(groundFactory, map1);
		world.addGameMap(initialMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		/**
		 * STROMVEILCASTLE
		 */
		FancyGroundFactory stormGroundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new GustOfWind(), new Cage(), new Barrack(),
		new Cliff());

		List<String> stormVeilMap = Arrays.asList(
				"...........................................................................",
				"..................<...............<........................................",
				"...........................................................................",
				"##############################################...##########################",
				"............................#................#.......B..............B......",
				".....B...............B......#................#.............................",
				"...............................<.........<.................................",
				".....B...............B......#................#.......B..............B......",
				"............................#................#.............................",
				"#####################..#############...############.####..#########...#####",
				"...............#++++++++++++#................#++++++++++++#................",
				"...............#++++++++++++...<.........<...#++++++++++++#................",
				"...............#++++++++++++..................++++++++++++#................",
				"...............#++++++++++++#................#++++++++++++#................",
				"#####...##########.....#############...#############..#############...#####",
				".._______........................B......B........................B.....B...",
				"_____..._..____....&&........<..............<..............................",
				".........____......&&......................................................",
				"...._______..................<..............<....................<.....<...",
				"#####....##...###..#####...##########___###############......##.....####...",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++");
		GameMap stormVeilCastle = new GameMap(stormGroundFactory, stormVeilMap);
		world.addGameMap(stormVeilCastle);


		/**
         * ROUNDTABLE HOLD
         */

		FancyGroundFactory roundGroundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(), new GustOfWind(), new PuddleOfWater(), new Cliff());

		List<String> roundTableMap = Arrays.asList(
				"##################",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"########___#######"); //11 down,  10 accross
		GameMap roundTableHold = new GameMap(roundGroundFactory, roundTableMap);
		world.addGameMap(roundTableHold);


		/**
		 * BOOS ROOM
		 */

		FancyGroundFactory bossGroundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(), new GustOfWind(), new PuddleOfWater(), new Cliff());

		List<String> bossMap = Arrays.asList(
				"+++++++++++++++++++++++++",
				".........................",
				".._......................",
				".........................",
				".........................",
				".........................",
				".........................",
				".........................",
				"+++++++++++++++++++++++++");
		GameMap bossRoom = new GameMap(bossGroundFactory, bossMap);
		bossRoom.at(12,4).addItem(new RemembranceOfTheGrafted());
		world.addGameMap(bossRoom);

		initialMap.at(38,11).setGround(new TheFirstStep());
		RestLocationManager.storeLastLocation(initialMap.at(38,11));
		initialMap.at(40,12).addActor(new MerchantK());
		initialMap.at(30, 11).setGround(new Cliff());

		roundTableHold.at(9,1).addActor(new FingerReaderEnia());
		// setting up the map teleporters
		initialMap.at(30,0).setGround(new GoldenFogDoor(stormVeilCastle.at(38,23), stormVeilCastle, "Storm Veil Castle"));
		initialMap.at(6,23).setGround(new GoldenFogDoor(roundTableHold.at(9,10), roundTableHold, "Roundtable Hold"));
		stormVeilCastle.at(6,0).setGround(new GoldenFogDoor(bossRoom.at(0,4), bossRoom, "Godrick the Grafted's room"));
		stormVeilCastle.at(38,23).setGround(new GoldenFogDoor(initialMap.at(30,0), initialMap, "Limgrave"));

		Player player = new Player("Tarnished", '@', 300);

		world.addPlayer(player, initialMap.at(36, 10));
		player.addItemToInventory(new RemembranceOfTheGrafted()); //this is here to test trading functionality
		world.run();

	}
}
