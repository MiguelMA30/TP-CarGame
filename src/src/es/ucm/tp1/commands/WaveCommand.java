package es.ucm.tp1.commands;

import es.ucm.tp1.exceptions.CommandExecuteException;
import es.ucm.tp1.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.logic.Buyable;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.actions.WaveAction;

public class WaveCommand extends Command implements Buyable {

	private static final String NAME = "wave";

	private static final String DETAILS = "[w]ave";

	private static final String SHORTCUT = "w";

	private static final String HELP = "push back objects in the game";

	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			buy(game);
			new WaveAction().execute(game);
		} catch (NotEnoughCoinsException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG, e));
		}
		return true;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 5;
	}

}
