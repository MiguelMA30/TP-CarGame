package es.ucm.tp1.gameobjects;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.actions.ExplosionAction;


public class Grenade extends GameObject {

	public static final Object INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around";
	private int ciclos;
	
	public Grenade(Game game, int row, int colum) {
		super(game,row,colum);
		this.ciclos=3;
		symbol="ð"+"["+this.ciclos+"]";
	}

	
	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		this.ciclos=3;
		game.setDistanceToGrenade(x, y);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		if(this.ciclos==0) {
			isAlive=false;
			onDelete();
			
		}
		symbol="ð"+"["+this.ciclos+"]";
		this.ciclos=this.ciclos-1;
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		(new ExplosionAction()).execute(game);
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
		return true;
	}


	@Override
	public boolean receiveThunder() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String serialize() {
		return super.serialize()+ " "+this.ciclos;
	}

}



