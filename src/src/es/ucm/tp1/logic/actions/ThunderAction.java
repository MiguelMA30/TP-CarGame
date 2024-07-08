package es.ucm.tp1.logic.actions;

import java.util.Random;

import es.ucm.tp1.logic.Collider;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.InstantAction;

public class ThunderAction implements InstantAction {

    private Random rand;
    @Override
    public void execute(Game game) {
        // TODO Auto-generated method stub
    	this.rand=new Random();
        int ColRand= (int) (rand.nextDouble() * (game.getVisibility() -1));
        int CarrilRand = (int) (rand.nextDouble() * game.getWidth());
        String s=("Thunder hit position:"+ "["+CarrilRand+", "+ColRand+"]");
        System.out.print(s);
        for(int i=game.getPlayer().getY()+1;i< game.getVisibility()+ game.getPlayer().getY();i++) {
            Collider c = game.getObjectInPosition(CarrilRand,ColRand+game.getCycles());
            if(c!=null) {
                c.receiveThunder();
                
                
                
            }
          
        }
        System.out.println();
        
    }

}
