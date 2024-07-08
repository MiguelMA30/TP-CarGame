package es.ucm.tp1.commands;

import es.ucm.tp1.logic.Game;


public class NoneCommand extends Command {

	private static final String NAME = "none";

	private static final String DETAILS = "[n]one";

	private static final String SHORTCUT = "n";

	private static final String HELP = "do nothing";

	public NoneCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	@Override
	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
				if (words.length != 1) {
					System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
					return null;
				} else {
					return this;
				}
			}else{
				if(words[0].equals("")) {//preguntar si esta bien hacerlo
					return this;
				}
		}
		return null;
	}
	
	
	
	@Override
	public boolean execute(Game game) {
		// TODO Add your code
		game.update();
		return true;
	}

}
