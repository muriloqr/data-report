package br.com.datareport.executor;

import java.util.stream.Stream;

import br.com.datareport.converter.DataReportConverter;
import br.com.datareport.model.ReportModel;
import br.com.datareport.reader.DataReader;
import br.com.datareport.writer.DataWriter;

public class DataExecutor {
	
	private DataReader dataReader = new DataReader();
	private DataReportConverter dataReportConverter = new DataReportConverter();
	private DataWriter dataWriter = new DataWriter();
	
	public void execute() {
		try {
			Stream<String> readData = dataReader.readData();
			ReportModel reportOfData = dataReportConverter.convert(readData);
			dataWriter.writeData(dataReportConverter.convertToString(reportOfData));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
