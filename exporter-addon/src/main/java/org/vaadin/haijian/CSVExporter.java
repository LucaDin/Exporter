package org.vaadin.haijian;

import com.vaadin.data.Container;
import com.vaadin.ui.Table;

import java.util.Date;

import org.vaadin.haijian.filegenerator.CSVFileBuilder;
import org.vaadin.haijian.filegenerator.FileBuilder;

public class CSVExporter extends Exporter {
	
    public CSVExporter() {
        super();
    }

    public CSVExporter(Table table) {
        super(table);
    }

    public CSVExporter(Container container, Object[] visibleColumns) {
        super(container, visibleColumns);
    }

    public CSVExporter(Container container) {
        super(container);
    }

    @Override
    protected FileBuilder createFileBuilder(Container container) {
        // TODO Auto-generated method stub
        return new CSVFileBuilder(container);
    }
    
    @Override
    protected String getDefaultDownloadFileName() {		
		return "exported-csv-" + getDateTimeFmt().format(new Date()) + ".csv";
	}
    
    @Override
    protected String getDownloadFileName() {
    	if(downloadFileName == null){
    		return getDefaultDownloadFileName();
        }
    	if(downloadFileName.endsWith(".csv")){
    		return downloadFileName;
    	}else{
    		return downloadFileName + "-" + getDateTimeFmt().format(new Date()) + ".csv";
    	}
    }

}
