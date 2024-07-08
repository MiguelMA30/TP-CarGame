package es.ucm.tp1.logic.actions;

import es.ucm.tp1.logic.Collider;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.InstantAction;

public class ExplosionAction implements InstantAction {

	@Override
	public void execute(Game game) {

//		// TODO Auto-generated method stub

		int x = game.getDistanceX();
		int y = game.getDistanceY();

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {

				Collider c = game.getObjectInPosition((y + j), (x + i));
				if (c != null) {
					c.receiveExplosion();
				}

			}
		}
	}
}

	

