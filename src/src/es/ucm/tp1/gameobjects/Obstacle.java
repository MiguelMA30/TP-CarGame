package es.ucm.tp1.gameobjects;

import es.ucm.tp1.logic.Game;

public class Obstacle extends GameObject {
	private static int GameObstaclesCount;
	public static final String INFO = "[Obstacle] hits car";
	
	public Obstacle(Game game, int row, int colum) {
		super(game,row,colum);
		symbol="░";
	}

	public static int getGameObstaclesCount() {
		return GameObstaclesCount;
	}

	public static void setGameObstaclesCount(int gameObstaclesCount) {
		GameObstaclesCount = gameObstaclesCount;
	}
	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		player.setCrash(true);
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		Obstacle.setGameObstaclesCount(Obstacle.getGameObstaclesCount() + 1);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		Obstacle.setGameObstaclesCount(Obstacle.getGameObstaclesCount() -1);
		
	}

	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
		this.isAlive=false;
		onDelete();
		return true;
	}

	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		
		
		return receiveShoot();
	}

	@Override
	public boolean receiveWave() {
		// TODO Auto-generated method stub
		if (game.objectPositionEmpty(this.y+ 1, this.x)) {
			this.y++;
		
			return true;
		}
		return false;
	}

	public static void reset() {
		// TODO Auto-generated method stub
		Obstacle.setGameObstaclesCount(0);
	}

	@Override
	public boolean receiveThunder() {
		// TODO Auto-generated method stub
		this.isAlive=false;
		game.removeDead(this);
		System.out.print("->"+" "+this.symbol);
		return true;
	}

}
