package es.ucm.tp1.logic;

import es.ucm.tp1.exceptions.NotEnoughCoinsException;

public interface Buyable   {
public int cost();
public default boolean buy(Game game) throws NotEnoughCoinsException{
	if(game.hasCoins(cost())){
		game.decrementCoins(cost());
		return true;
		
	}
	else {
		throw new NotEnoughCoinsException("No tienes monedas suficientes") ;
	}

};
}
