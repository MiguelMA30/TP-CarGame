package es.ucm.tp1.logic;

import es.ucm.tp1.gameobjects.GameObject;
import es.ucm.tp1.gameobjects.Player;

public interface Collider {

	boolean doCollision();

	boolean receiveCollision(Player player);
	
	boolean receiveShoot();
	
	boolean receiveExplosion();

	boolean receiveWave();

	boolean receiveThunder();

}
