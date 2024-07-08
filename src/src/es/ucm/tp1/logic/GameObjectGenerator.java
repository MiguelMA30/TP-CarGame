package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.gameobjects.Coin;
import es.ucm.tp1.gameobjects.GameObject;
import es.ucm.tp1.gameobjects.Grenade;
import es.ucm.tp1.gameobjects.Obstacle;
import es.ucm.tp1.gameobjects.Pedestrian;
import es.ucm.tp1.gameobjects.SuperCoin;
import es.ucm.tp1.gameobjects.Truck;
import es.ucm.tp1.gameobjects.Turbo;
import es.ucm.tp1.gameobjects.Wall;
import es.ucm.tp1.logic.actions.ThunderAction;

// TODO add your imports

public class GameObjectGenerator {

	public static void generateGameObjects(Game game, Level level) {
		for(int x = game.getVisibility() /2; x < game.getRoadLength(); x ++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomWidth()), level.getObstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomWidth()), level.getCoinFrequency());
			if (level . hasAdvancedObjects()) {
				game.tryToAddObject(new Wall(game, x, game.getRandomWidth()), level.
				advancedObjectsFrequency());
				game.tryToAddObject(new Turbo(game, x, game.getRandomWidth()), level.
				advancedObjectsFrequency());
				if (! SuperCoin.hasSuperCoin()) {
				game.tryToAddObject(new SuperCoin(game, x, game.getRandomWidth())
				, level . advancedObjectsFrequency());
				}
				game.tryToAddObject(new Truck(game, x, game.getRandomWidth()), level.
				advancedObjectsFrequency());
				game.tryToAddObject(new Pedestrian(game, x, 0), level.advancedObjectsFrequency());
				
				}
			}
		
	
}

	public static void reset(Level level) {
		// TODO add your code
		Obstacle.reset ();
		Coin.reset ();
	}


	public static void forceAdvanceObject(Game game, int id, int x) {
		GameObject o = null;
		switch (id) {
		case 1:
		o = new Wall(game, x, game.getRandomWidth());
		break;
		case 2:
		o = new Turbo(game, x, game.getRandomWidth());
		break;
		case 3:
		o = new SuperCoin(game, x, game.getRandomWidth());
		break;
		
		case 4:
		o = new Truck(game, x, game.getRandomWidth());
		break;
		case 5:
		o = new Pedestrian(game, x, 0);
		break;
		}
		game.forceAddObject(o);
		}

public static void generateRuntimeObjects(Game game) {
if (game.getLevel().hasAdvancedObjects())
(new ThunderAction()).execute(game);
}
}