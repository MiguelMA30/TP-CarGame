package es.ucm.tp1.logic.actions;

import es.ucm.tp1.logic.Collider;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.InstantAction;

public class ShootAction implements InstantAction {

	@Override
	public void execute(Game game) {

//		// TODO Auto-generated method stub
		int i=game.getPlayer().getY()+1;
		boolean detener=false;
		while(i< game.getVisibility()+ game.getPlayer().getY() &&!detener) {
			Collider c = game.getObjectInPosition(game.getPlayer().getX(), i);

			if(c!=null && c.receiveShoot()) {
				detener=true;
				
			}
			else {
				i++;
			}
			
		}
	}
}
