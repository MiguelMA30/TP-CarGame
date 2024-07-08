package es.ucm.tp1.gameobjects;

import es.ucm.tp1.logic.Game;

public class Coin extends GameObject{
	
	private static int gameCoinsCount;
	public static final Object INFO = "[Coin] gives 1 coin to the player";

	public Coin(Game game, int row, int col) {
		super(game,row,col);
		symbol= "¢";
		this.isAlive = true;
	}

	public static void setGameCoinsCount(int gameCoinsCount) {
		Coin.gameCoinsCount = gameCoinsCount;
	}
	
	public static int getGameCoinsCount() {
		return gameCoinsCount;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean GetisAlive() {
		return isAlive;
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		Coin.setGameCoinsCount(Coin.getGameCoinsCount() - 1);
		player.incrementCoin();
		setAlive(false);
//		game.removeCoin();
		onDelete();
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		Coin.setGameCoinsCount(Coin.getGameCoinsCount() + 1);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDelete() {
//		// TODO Auto-generated method stub
		game.removeDead(this);
	}

	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		return false;
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
		Coin.setGameCoinsCount(0);
	}

	@Override
	public boolean receiveThunder() {
		// TODO Auto-generated method stub
	
		return false;
	}
}
