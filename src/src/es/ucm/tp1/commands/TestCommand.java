package es.ucm.tp1.commands;

import es.ucm.tp1.logic.Game;

public class TestCommand extends Command {

	private static final String NAME = "test";

	private static final String DETAILS = "[t]est";

	private static final String SHORTCUT = "t";

	private static final String HELP = "mode test on";

	public TestCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		// TODO Add your code
		game.isTestActivated();
		return true;
	}
}
