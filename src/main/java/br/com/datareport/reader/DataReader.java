package br.com.datareport.reader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataReader {
	
	private static final String READ_DIR = System.getProperty("user.home") + "/data/in"; 
	private static final String CHARSET_NAME = "ISO-8859-1";
	
	
	public Stream<String> readData() throws Exception {
		List<String> lines = new ArrayList<String>();
		
		if (getFilesPaths().count() == 0) {
			throw new Exception("Não há arquivos na pasta " + READ_DIR);
		}
		
		getFilesPaths().forEach(path -> {
			List<String> pathLines = getLines(path).collect(Collectors.toList());
			
			lines.addAll(pathLines);
		});
		
		return lines.stream();
	}
	
	private Stream<String> getLines(String path) {
		Stream<String> allLines = null;
		
		try {
			allLines = Files.lines(Paths.get(path), Charset.forName(CHARSET_NAME));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return allLines;
	}

	private Stream<String> getFilesPaths() {
		Stream<String> paths = null;
		
		try {
			paths = Files.list(Paths.get(READ_DIR))
					.map(path -> path.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return paths;
	}
}
