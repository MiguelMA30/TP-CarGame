package es.ucm.tp1.commands;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.StringUtils;

public class ResetCommand extends Command {

	private static final String NAME = "reset";

	private static final String DETAILS = "[r]eset [<level> <seed>]";

	private static final String SHORTCUT = "r";

	private static final String HELP = "reset the game";
	private Level level;
	private long seed;

	private boolean fullreset;
	
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		// TODO Add your code
		if(fullreset) {
			game.reset(level,seed);
		}else {
			game.reset();
		}
		
		
		return true;
	}
public Command parse(String[] commandWords) throws CommandParseException {
		
		if (matchCommandName(commandWords[0])){
			if (commandWords.length == 1) {
				fullreset = false;
				return this;
			}else if (commandWords.length == 3) {
				level= Level.valueOfIgnoreCase(commandWords[1]);
				if(level == null) {
					throw new CommandParseException("Level not defined."+"\nTry: test, easy, hard or advanced");
				}
				try {
					seed=Long.parseLong(commandWords[2]);
				} catch (NumberFormatException e) {
					throw new CommandParseException("Seed must be a number");
				}
				fullreset = true;
				return this;
			}
			else {
				throw new CommandParseException(
						String.format("[ERROR]:Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
			}
		}
		
		return null;
		}


}

