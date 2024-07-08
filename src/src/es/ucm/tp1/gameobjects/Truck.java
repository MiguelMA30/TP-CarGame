package es.ucm.tp1.gameobjects;

import es.ucm.tp1.logic.Game;

public class Truck extends Obstacle {

	public static final Object INFO = "[TRUCK] moves towards the player";
	

	public Truck(Game game, int x, int y) {
		super(game, x, y);
		symbol="←";
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
			
		return false;
	}
	

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		y--;
		if(doCollision()) {
			game.getPlayer().setDyingNextCycle(true);
		}
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	
	


	}




