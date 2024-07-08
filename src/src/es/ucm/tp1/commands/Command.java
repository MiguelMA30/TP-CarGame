package es.ucm.tp1.commands;

import java.text.ParseException;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.exceptions.CommandExecuteException;
import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Buyable;

public abstract class Command  {

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";
	
	protected static final Object FAILED_MSG = "No tienes suficientes monedas";
	
	protected static final Object UNVALID_POSITION = "No se puede colocar en esa posicion";

	/* @formatter:off */
	protected static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new ResetCommand(),
		new TestCommand(),
		new ExitCommand(),
		new NoneCommand(),
		new UpCommand(),
		new DownCommand(),
		new ShootCommand(),
		new GrenadeCommand(),
		new WaveCommand(),
		new ClearCommand(),
		new CheatCommand(),
		new SerializeCommand(),
		new SaveCommand(),
		new DumpCommand(),
		new ShowRecordCommand()
	};
	
	/* @formatter:on */

	public static Command getCommand(String[] commandWords) throws CommandParseException {
		Command command = null;
		for(int i=0;i< AVAILABLE_COMMANDS.length;i++) {
			command=AVAILABLE_COMMANDS[i].parse(commandWords);
			if(command!=null) {
				return command;
			}

		}
			throw new CommandParseException("[ERROR]: "+ UNKNOWN_COMMAND_MSG);
	}

	private final String name;

	private final String shortcut;

	private final String details;

	private final String help;

	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public abstract boolean execute(Game game) throws CommandExecuteException;

	protected boolean matchCommandName(String name) {

		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}

	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				throw new CommandParseException(
						String.format("[ERROR]:Command %s: %s", name, INCORRECT_NUMBER_OF_ARGS_MSG));
			} else {
				return this;
			}
		}
		return null;
	}

	public String helpText(){
		return details + ": " + help + "\n";
	}
}
