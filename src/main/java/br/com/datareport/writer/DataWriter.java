package br.com.datareport.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
	
	private static final String WRITE_DIR = System.getProperty("user.home") + "/data/out/";
	private static final String FILENAME = "report";
	
	public void writeData(String data) {
		try {
		    BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(WRITE_DIR + FILENAME));
			
		    writer.write(data);
		     
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
