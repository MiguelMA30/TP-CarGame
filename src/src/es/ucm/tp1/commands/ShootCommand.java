package es.ucm.tp1.commands;

import es.ucm.tp1.exceptions.CommandExecuteException;
import es.ucm.tp1.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.logic.Buyable;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.actions.ShootAction;
import es.ucm.tp1.logic.actions.WaveAction;

public class ShootCommand extends Command implements Buyable {
	
	private static final String NAME = "shoot";

	private static final String DETAILS = "[s]hoot";

	private static final String SHORTCUT = "s";

	private static final String HELP = "shoot a bullet";

	public ShootCommand() {
		super(NAME, SHORTCUT,DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		
		try {
			buy(game);
			new ShootAction().execute(game);
			game.update();
			
		} catch (NotEnoughCoinsException e) {
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG, e));
		}
		return true;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 1;
	}

}
