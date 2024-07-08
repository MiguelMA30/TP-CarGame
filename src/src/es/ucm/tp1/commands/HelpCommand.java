package es.ucm.tp1.commands;



import es.ucm.tp1.logic.Game;

public class HelpCommand extends Command {

	private static final String NAME = "help";

	private static final String DETAILS = "[h]elp";

	private static final String SHORTCUT = "h";

	private static final String HELP = "show this help";

	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	private static final String commandHelpMsg = "Available commands:\n";

	public String helpCommandsText() {
		String helpMsg = commandHelpMsg;
		for (Command command : AVAILABLE_COMMANDS) {
			helpMsg +=command.helpText(); 
		}
		
		return helpMsg;
	}

	public boolean execute(Game game) {
		System.out.println(this.helpCommandsText());

		return false;
	}

}

