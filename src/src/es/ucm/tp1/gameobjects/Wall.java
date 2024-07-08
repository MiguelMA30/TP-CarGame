package es.ucm.tp1.gameobjects;

import es.ucm.tp1.logic.Game;

public class Wall extends Obstacle {

	public static final Object INFO ="[WALL] hard obstacle";
	private int vidas;
	private static final String SYMBOL_2 ="▒";
	private static final String SYMBOL_1="░";
	private static final String SYMBOL_3="█";
	
	public Wall(Game game, int x, int y) {
		super(game, x, y);
		vidas=3;
		// TODO Auto-generated constructor stub
	}
	

	

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		
		super.receiveCollision(player);
		return false;
	}

	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
		vidas--;
		if(vidas<=0) {
			onDelete();
			isAlive=false;
		}
		return true;
	}
	public boolean receiveExplosion() {
		return receiveShoot();
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		game.removeDead(this);
		game.incrementCoins(5);
	}

	public int getVidas() {
		return vidas;
	}
	@Override
	protected String getSymbol() {
		if (vidas==1) {
			return SYMBOL_1 ;
		}else if(vidas==2) {
			return SYMBOL_2;
		}else if(vidas==3){
			return SYMBOL_3;
		}else return "";
	}
	
	@Override
	public String serialize() {
		return super.serialize()+ " "+this.vidas;
	}

	}

