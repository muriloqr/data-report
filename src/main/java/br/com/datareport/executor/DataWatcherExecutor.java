package br.com.datareport.executor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class DataWatcherExecutor {
	
	private static final String WATCH_DIR = System.getProperty("user.home") + "/data/in";
	
	private DataExecutor dataExecutor = new DataExecutor();
	
	public void executeWatcher() {
		
		Path path = Paths.get(WATCH_DIR);
		
		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();
	
			path.register(
			          watchService, 
			            StandardWatchEventKinds.ENTRY_CREATE,
			            StandardWatchEventKinds.ENTRY_DELETE);
			
	        try {
	        	WatchKey key;
	        	
				while ((key = watchService.take()) != null) {
					key.pollEvents().forEach(event -> dataExecutor.execute());
				    key.reset();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
