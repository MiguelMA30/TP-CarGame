package es.ucm.tp1.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.exceptions.CommandExecuteException;
import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GameSerializer;

public class SaveCommand extends Command {
	private static final String NAME ="Save";

	private static final String DETAILS = "Sa[v]e";

	private static final String SHORTCUT = "v";

	private static final String HELP = "save the game";
	
	private String filename;
		
	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 1)
				throw new CommandParseException("Error: Save must be followed by a filename");
			else if (commandWords.length !=2)
				throw new CommandParseException("Unvalid filename: the filename contains spaces");
			else {
				filename= commandWords[1]+".txt";
				return this;
			}
		}
		return null;
		
	}
	@Override
	public boolean execute(Game game) throws CommandExecuteException {

		try( 
			
			BufferedWriter outStream = new BufferedWriter(new FileWriter(filename))) {
			// Se crea el archivo sobre el que se volcará el juego
			// Se escribe la cabecera
			outStream.write("Super cars 3.0");
			
			outStream.newLine();
			//Se escribe la serialización en el archivo
			outStream.write(new GameSerializer(game).toString());
			// Se escribe por consola que la operación tuvo éxito
			System.out.println("Game successfully saved in file" +" "+filename);
			
			return false;
			} catch (IOException ioe) {
				throw new CommandExecuteException("IO Error");
			}
	}

}
