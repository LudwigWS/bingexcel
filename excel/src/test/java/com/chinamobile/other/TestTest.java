package com.chinamobile.other;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bing.excel.vo.CellKV;
import com.bing.excel.vo.ListLine;
import com.bing.excel.writer.ExcelWriterFactory;
import com.bing.excel.writer.WriteHandler;

public class TestTest {
	@Test
	public void testme() {
		WriteHandler handler = ExcelWriterFactory.createSXSSF("E:/aoptest/big.xlsx");
List<CellKV<String>> listStr=new ArrayList<>();
listStr.add(new CellKV<String>(0, "diyi"));
		handler.createSheet("aa");
		handler.writeHeader(listStr);
		handler.writeLine(new ListLine().addValue(0, true));
		handler.flush();
		
	}
	@Test
	public void testA() {
		String i=null;
		try {
				i.equals("a");
		} catch (Exception e) {
			throw new RuntimeException("test for me");
		}finally {
			System.out.println(123);
		}
	}
}
