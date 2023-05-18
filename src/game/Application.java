package game;

import game.environments.spawning.Dragonbarrow;
import game.environments.spawning.Graveyard;
import game.environments.spawning.GustOfWind;
import game.environments.spawning.PuddleOfWater;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.*;
import game.actors.MerchantK;
import game.actors.Player;
import game.controllers.RestLocationManager;
import game.environments.*;
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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(), new GustOfWind(), new PuddleOfWater(), new Dragonbarrow());

		List<String> map = Arrays.asList(
				"..nnnn................................................~~~~~~~~~~~~~~~~~~~~~",
				"......................#####....######..................~~~~~~~~~~~~~~~~~~~~",
				"..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~",
				"..................................__#....................~~~~~~~~~~~~~~~~~~",
				"......................._____........#.....................~~~~~~~~~~~~~~~~~",
				"......................#............_#......................~~~~~~~~~~~~~~~~",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~~~......................________#....nnnn........................",
				"~~~~~~~~~~~~~.....................#________................................",
				"~~~~~~~~~~~~......................#_______#....nnnn........................",
				"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~..........................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##...........................................&&&......######..##...",
				"..#.....__...........................................&&&......#....____....",
				"..#___..............&&&..............................&&&........__.....#...",
				"..####__###.........&&&.............rrrr......................_.....__.#...",
				"....................&&&.......................................###..__###...",
				"...........................................................................");
		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}


		gameMap.at(38,11).setGround(new TheFirstStep());
		RestLocationManager.storeLastLocation(gameMap.at(38,11));
		gameMap.at(40,12).addActor(new MerchantK());


		// HINT: what does it mean to prefer composition to inheritance?
		Player player = new Player("Tarnished", '@', 300);
		world.addPlayer(player, gameMap.at(36, 10));

		world.run();
	}
}
