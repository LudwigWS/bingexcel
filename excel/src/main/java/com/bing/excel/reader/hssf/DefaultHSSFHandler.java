package com.bing.excel.reader.hssf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.xml.sax.SAXException;

import com.bing.excel.reader.ExcelReadListener;
import com.bing.excel.reader.SaxHandler;
import com.bing.excel.reader.vo.CellKV;
import com.bing.excel.reader.vo.ListRow;

public class DefaultHSSFHandler extends HSSFListenerAbstract  implements SaxHandler{

	private ExcelReadListener excelReader;
	
	
	
	
	
	public DefaultHSSFHandler(String path, ExcelReadListener excelReader)
			throws  FileNotFoundException, IOException, SQLException {
		this(path,excelReader,false);
	}
	
	public DefaultHSSFHandler(InputStream in,  ExcelReadListener excelReader)
			throws  SQLException, IOException {
		this(in,excelReader,false);
	}
	
	public DefaultHSSFHandler(POIFSFileSystem fs, ExcelReadListener excelReader)
			throws SQLException {
		this(fs,excelReader,false);
		
	}
	
	public DefaultHSSFHandler(String path, ExcelReadListener excelReader,boolean ignoreNumFormat)
			throws  FileNotFoundException, IOException, SQLException {
		this(new FileInputStream(path),excelReader,ignoreNumFormat);
		
	}
	
	public DefaultHSSFHandler(InputStream in,  ExcelReadListener excelReader,boolean ignoreNumFormat)
			throws  SQLException, IOException {
		this(new POIFSFileSystem(in),excelReader,ignoreNumFormat);
		
	}
	
	public DefaultHSSFHandler(POIFSFileSystem fs, ExcelReadListener excelReader,boolean ignoreNumFormat)
			throws SQLException {
		super(fs,excelReader,ignoreNumFormat);
		this.excelReader = excelReader;
	}

	

	@Override
	public void readSheets() throws IOException, OpenXML4JException, SAXException {
		process();
		
	}

	@Override
	public void readSheet(int index) throws IOException, OpenXML4JException,
			SAXException {
		if(index>=0){
		setAimSheetIndex(index);
		}
		process();
	}

	@Override
	public void readSheet(String indexName) throws IOException,
			OpenXML4JException, SAXException {
		setAimSheetName(indexName);		
		process();
	}

	@Override
	public void optRows(int sheetIndex, int curRow, ListRow rowlist)
			throws SQLException {
		//System.out.println("sheet:"+sheetIndex+"  curRow:"+curRow+"  rowlist:"+rowlist);
		excelReader.optRow(curRow, rowlist);
	}
	
}
