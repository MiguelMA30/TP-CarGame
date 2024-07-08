package es.ucm.tp1.commands;

import es.ucm.tp1.exceptions.CommandExecuteException;
import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.exceptions.UnvalidPositionException;
import es.ucm.tp1.gameobjects.Grenade;
import es.ucm.tp1.logic.Buyable;
import es.ucm.tp1.logic.Game;

public class GrenadeCommand extends Command implements Buyable {

	private static final String NAME = "grenade";

	private static final String DETAILS = "[g]renade <x> <y>";

	private static final String SHORTCUT = "g";

	private static final String HELP = " add a grenade in position x, y";
	private int xPosition;
	private int yPosition;

	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		try {
			if(!game.objectPositionEmpty(xPosition+game.getPlayer().getX(),yPosition) || (!game.PositionValid(xPosition+game.getPlayer().getX(),yPosition))) {
				throw new UnvalidPositionException(String.format("[ERROR]: %s", UNVALID_POSITION));
			}
			buy(game);
			game.forceAddObject(new Grenade(game, (xPosition + game.getCycles()), yPosition));
			game.setDistanceToGrenade(xPosition + game.getCycles(), yPosition);
			game.update();
		} catch (NotEnoughCoinsException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG));
		}
		return true;
	}

	public Command parse(String[] commandWords) throws CommandParseException {
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length != 3)
				throw new CommandParseException(
						String.format("[ERROR]:Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
			else {

				try {
					xPosition = Integer.parseInt(commandWords[1]);
					yPosition = Integer.parseInt(commandWords[2]);
				} catch (NumberFormatException exception) {
					throw new CommandParseException("[ERROR]: El argumento debe ser un entero");
				}
			}
			return this;
		}
		return null;
		
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 3;
	}

}