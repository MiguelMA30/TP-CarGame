package es.ucm.tp1.commands;

import es.ucm.tp1.logic.Game;

public class DownCommand extends Command {

	private static final String NAME = "down";

	private static final String DETAILS = "[a]";

	private static final String SHORTCUT = "a";

	private static final String HELP = "go down";
	
	public DownCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.goDown();
		game.update();
		return true;
	}

}
