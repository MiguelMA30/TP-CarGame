package es.ucm.tp1.commands;

import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.GameObjectGenerator;

public class CheatCommand extends Command{
	private static final String NAME = "cheat";

	private static final String DETAILS = "Cheat [1..5]";

	private static final String SHORTCUT = "c";

	private static final String HELP = " Removes all elements of last visible column, and adds an Advanced Object";
	int x;
	public CheatCommand() {
		super(NAME, SHORTCUT,DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		int lc=game.getPlayer().getY()+7;
		game.clearColumn(lc);
		GameObjectGenerator.forceAdvanceObject(game, x, lc);
		return true;
	}
	public Command parse(String[] commandWords) throws CommandParseException{
		String s;
		if (matchCommandName(commandWords[0])){
			if(commandWords.length !=2) {
				throw new CommandParseException(String.format("[ERROR]:Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
			}
			
			try {
				x=Integer.parseInt(commandWords[1]);
			} catch (NumberFormatException e) {
				throw new CommandParseException("[ERROR]: El argumento debe ser un entero");
			}
			if(x<1 || x >5) {
				s = "[ERROR]: El numero "+commandWords[1]+ " no equivale a ningun objeto.\n ";
				s+= "1 = Wall \n";
				s+= "2 = Turbo \n" ;
				s+= "3 = SuperCoin \n";
				s+= "4 = Truck \n";
				s+= "5 = Pedestrian \n";
				throw new CommandParseException(s);
			}
			
			
				return this;
				
		}
		return null;
	}

}
