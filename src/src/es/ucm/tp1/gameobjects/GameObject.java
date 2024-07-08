package es.ucm.tp1.gameobjects;

import es.ucm.tp1.logic.Collider;
import es.ucm.tp1.logic.Game;

public abstract class GameObject implements Collider {

	protected int x, y;

	protected Game game;
	
	protected boolean isAlive;

	protected String symbol;//hacerlo todo estatico sol.1

	public GameObject(Game game, int x, int y) {
		this.y = x;// y es la fila,with
		this.x = y;//x es la columna, length
		this.game = game;
		isAlive=true;
	}

	protected String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		if (isAlive) {
			return getSymbol();
		}

		return "";
	}

	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();
	public abstract boolean receiveThunder();
	public abstract boolean receiveWave();
	public abstract boolean receiveShoot();
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	public String serialize() {
		return getSymbol() + "("+y+", "+x+")";
		}
	public String getName() {
		// TODO Auto-generated method stub
		return symbol;
	}


	// TODO add your code

}
