package br.com.datareport;

import br.com.datareport.executor.DataExecutor;
import br.com.datareport.executor.DataWatcherExecutor;

public class DataReportApp {

	public static void main(String[] args) {
		DataExecutor dataExecutor = new DataExecutor();
		DataWatcherExecutor dataWatcher = new DataWatcherExecutor();

		dataExecutor.execute();
		dataWatcher.executeWatcher();
	}

}
