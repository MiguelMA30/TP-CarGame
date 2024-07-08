package es.ucm.tp1.commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.exceptions.CommandExecuteException;
import es.ucm.tp1.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GameSerializer;

public class DumpCommand extends Command {
	private static final String NAME ="Dump";

	private static final String DETAILS = "[d]ump";

	private static final String SHORTCUT = "d";

	private static final String HELP = "copy textfile";
	
	private String filename;
	
	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		//Command command = null;
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
	@SuppressWarnings("resource")
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		 BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filename));
			 String line;
			 try {
				while ((line = br.readLine()) != null) {
				   System.out.println(line);
				 }
			} catch (IOException e) {
			throw new CommandExecuteException("IO Error");
			}
		} catch (FileNotFoundException e) {
			throw new CommandExecuteException("File not found");
		}
		
		 return false;
	}

}
