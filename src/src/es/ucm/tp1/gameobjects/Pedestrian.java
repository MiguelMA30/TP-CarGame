package es.ucm.tp1.gameobjects;

import es.ucm.tp1.logic.Game;

public class Pedestrian extends Obstacle {

	public static final Object INFO = "[PEDESTRIAN] person crossing the road up and down\n";
	private static boolean subir=false;
	public Pedestrian(Game game, int x, int y) {
		super(game, x, y);
		symbol="☺";
		// TODO Auto-generated constructor stub
	}

	




	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return (this.x==game.getPlayer().getX() && this.y==game.getPlayer().getY());
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		super.receiveCollision(player);
	
		game.decrementCoins(game.playerCoins());
		return false;
	}
	

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		if(x==0) {
			subir=false;
		}
		if(x==game.getWidth()-1)subir=true;
		if(!subir) {
			x++;
			
			
		}
		else {
			x--;
			
		}
		if(doCollision()) {
			game.getPlayer().setDyingNextCycle(true);
		}
		 
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
		
		game.decrementCoins(game.playerCoins());
		isAlive=false;
		return true;
	}
	@Override
	public String serialize() {
		if(subir) {
			return super.serialize()+ " up";
		}else {
			return super.serialize()+ " down";
		}
		
	}
	
	

}
