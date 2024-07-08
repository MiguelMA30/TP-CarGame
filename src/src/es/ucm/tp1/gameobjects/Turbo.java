package es.ucm.tp1.gameobjects;

import es.ucm.tp1.logic.Game;

public class Turbo extends GameObject {

	public Turbo(Game game, int x, int y) {
		super(game, x, y);
		symbol=">>>";
		// TODO Auto-generated constructor stub
	}

	public static final Object INFO = "[TURBO] pushes the car: 3 columns";

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		player.y+=3;
		return false;
	}

	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
		return false;
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
		
	}

	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean receiveThunder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveWave() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
