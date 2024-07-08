package es.ucm.tp1.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.exceptions.CommandExecuteException;
import es.ucm.tp1.exceptions.InputOutputRecordException;

public class Record {
private  Level level;
private static long currentRecord;

public Record(Level level, long currentRecord) {
	this.level=level;
	this.currentRecord= currentRecord;
}

@SuppressWarnings("resource")
public  static Record load (Level level) throws CommandExecuteException{
	 BufferedReader br;
	 Record record=null;
	 
		try {
			String nivel ="";
			
			br = new BufferedReader(new FileReader("Records.txt"));
			
			 String line;
				while ((line = br.readLine()) != null) {
				String[] parts=line.split(":");
				nivel=parts[0];
					if(nivel.equals(level.name())) {
						//currentRecord=Long.parseLong(parts[1]);
						record= new Record(level,Long.parseLong(parts[1]));
					}
				}
			}
		catch (IOException e) {
			throw new InputOutputRecordException("IO Error");
			}
		 catch (NumberFormatException e) {
			throw new InputOutputRecordException("Record is not a number");
		}
		return record;
	
	
}

@SuppressWarnings("resource")
public void save(Level level, long r) throws CommandExecuteException {

	try {
		BufferedReader br;
		String archivo="";
	
		br = new BufferedReader(new FileReader("Records.txt"));
		 String line;
		 try {
			
			while ((line = br.readLine()) != null ) {
			
			String[] parts=line.split(":");
			
		
			
			if(parts[0].equals(level.name())) {
				archivo+=level.name()+":"+r+"\n";
				
			}
			else {
				archivo+=line+"\n";
			}
			
	 
			 }
			br.close();
			
			BufferedWriter bf;
			bf = new BufferedWriter(new FileWriter("Records.txt"));
			bf.write(archivo);
			bf.close();

		} catch (IOException e) {
			throw new InputOutputRecordException("IO Error");
		}
	} catch (FileNotFoundException e) {
		throw new InputOutputRecordException("File not found");
	}

}

public static long getCurrentRecord() {
	return currentRecord;
}
}
