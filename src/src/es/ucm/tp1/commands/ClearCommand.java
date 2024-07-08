package es.ucm.tp1.commands;

import es.ucm.tp1.logic.Game;

public class ClearCommand extends Command {
	private static final String NAME = "clear";

	private static final String DETAILS = "Clear [0]";

	private static final String SHORTCUT = "0";

	private static final String HELP = "clears the road";

	public ClearCommand() {
		super(NAME, SHORTCUT,DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		
		// TODO Auto-generated method stub
		game.clear();
		return true;
	}

}
