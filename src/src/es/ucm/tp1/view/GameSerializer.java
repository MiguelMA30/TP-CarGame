package es.ucm.tp1.view;

import es.ucm.tp1.gameobjects.Coin;
import es.ucm.tp1.gameobjects.Obstacle;
import es.ucm.tp1.gameobjects.SuperCoin;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.StringUtils;
	
public class GameSerializer {
private Game game;




private static final String SUPERCOIN_PRESENT = "Supercoin is present";

private static final String DISTANCE_MSG = "Distance: ";

private static final String COINS_MSG = "Coins: ";

private static final String CYCLE_MSG = "Cycle: ";

private static final String TOTAL_OBSTACLES_MSG = "Total obstacles: ";

private static final String TOTAL_COINS_MSG = "Total coins: ";

private static final String ELAPSED_TIME_MSG = "Elapsed Time: ";


	public GameSerializer(Game game) {
		// TODO Auto-generated constructor stub
		this.game=game;
	}
	private static String formatTime(long t) {
		return String.format("%.2f s", t / 1000.0);
	}
	protected String getInfo() {
		StringBuilder buffer = new StringBuilder();
		/* @formatter:off */
		buffer
		.append(DISTANCE_MSG).append(game.distanceToGoal()).append(StringUtils.LINE_SEPARATOR)
		.append(COINS_MSG).append(game.playerCoins()).append(StringUtils.LINE_SEPARATOR)
		.append(CYCLE_MSG).append(game.getCycle()).append(StringUtils.LINE_SEPARATOR)
		.append(TOTAL_OBSTACLES_MSG).append(Obstacle.getGameObstaclesCount()).append(StringUtils.LINE_SEPARATOR)
		.append(TOTAL_COINS_MSG).append(Coin.getGameCoinsCount()+"\n");
		/* @formatter:on */
		if (game.getLevel().hasAdvancedObjects()) {
			if (SuperCoin.hasSuperCoin()) {
				buffer.append(SUPERCOIN_PRESENT);
			}
		}

		if (!game.toggleTest()) {
			/* @formatter:off */
			buffer
			.append(StringUtils.LINE_SEPARATOR)
			.append(ELAPSED_TIME_MSG).append(formatTime(game.elapsedTime()));
			/* @formatter:on */
		}

		return buffer.toString();
	}
	public String toString() {
		String info="";
		String s="";
		info+=this.getInfo();
		for(int i=game.getPlayer().getY();i<game.getRoadLength();i++) {
			for(int j=0;j<game.getWidth();j++) {
				
				s+=game.serializePosition(j,i);
				
			}
		}
		return "----- GAME ADVANCER SERIALIZED -----\n"+info+"\n"+"Game objects: \n"+s;
	}

}
