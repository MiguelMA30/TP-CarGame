package es.ucm.tp1.gameobjects;

import es.ucm.tp1.logic.Collider;
import es.ucm.tp1.logic.Game;


public class Player extends GameObject  {
	private int coins;
	private static final String SYMBOL_DEAD ="@";
	private static boolean isCrash;
	private boolean dyingNextCycle;
	
	public Player(Game game, int row,int col) {
		super(game,col,row);
		symbol=">";
		this.coins=5;
		Player.isCrash=false;
		this.dyingNextCycle=false;
		
	}
	public int getCoins() {
		return coins;
	}
	@Override
	protected String getSymbol() {
		if(isCrash) {
			return SYMBOL_DEAD;
		}else {
			return super.getSymbol();
		}
	
	}

	public void goUp() {
		// TODO Auto-generated method stub
		if(x>0) {
			x--;
			
			
		}
	}
	public void goDown() {
		// TODO Auto-generated method stub
		//ROW=X COL=Y
		if(x<(game.getWidth()-1)) {
		x++;
		
		}
	}
	public void update() {
		// TODO Auto-generated method stub
		
		if(this.dyingNextCycle) {
			Player.isCrash=true;
		}
		y++;
		doCollision();
		
		
	
		this.game.finJuego();
		
	}

	public boolean getIsCrash() {
		return isCrash;
	}
	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y);
		if (other != null) {
		
		return other.receiveCollision (this);
		}
		return false;
}
	public void incrementCoin() {
		// TODO Auto-generated method stub
		coins++;
	}
	public  void setCrash(boolean isCrash) {
		this.isCrash = isCrash;
	}
	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		
		return getSymbol();
	}
	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
		return false;
	}

	public void decrementCoins(int coins) {
		// TODO Auto-generated method stub
		this.coins-=coins;
	}
	public void incrementCoins(int coins) {
		// TODO Auto-generated method stub
		this.coins+=coins;
	}
	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean receiveWave() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setDyingNextCycle(boolean b) {
		this.dyingNextCycle=b;
	}
	@Override
	public boolean receiveThunder() {
		// TODO Auto-generated method stub
		return false;
	}
}

