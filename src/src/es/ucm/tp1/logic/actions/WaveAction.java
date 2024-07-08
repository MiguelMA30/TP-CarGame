package es.ucm.tp1.logic.actions;

import es.ucm.tp1.logic.Collider;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.InstantAction;

public class WaveAction implements InstantAction {


	@Override
	public void execute(Game game) {
		
		//	// TODO Auto-generated method stub

		for(int j=0;j<game.getWidth();j++) {
			for(int i=game.getPlayer().getY()+game.getVisibility()-2;i>=  game.getPlayer().getY();i--) {
				Collider c = game.getObjectInPosition(j, i);
				if(c!=null) {
					c.receiveWave();
				}	
				
			}
			

		}
	}
}


