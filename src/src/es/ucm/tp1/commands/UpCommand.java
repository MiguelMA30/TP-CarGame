package es.ucm.tp1.commands;

import es.ucm.tp1.exceptions.CommandExecuteException;
import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;

public class UpCommand extends Command {
	private static final String NAME = "up";

	private static final String DETAILS = "[q]";

	private static final String SHORTCUT = "q";

	private static final String HELP = "go up";
	public UpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		game.goUp();
		game.update();
		return true;
	}
}
