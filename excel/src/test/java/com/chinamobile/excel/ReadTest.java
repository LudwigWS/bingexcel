package com.chinamobile.excel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;

import com.chinamobile.excel.annotation.CellConfig;
import com.chinamobile.excel.core.BingExcel;
import com.chinamobile.excel.core.BingExcelBuilder;
import com.chinamobile.excel.core.impl.BingExcelImpl.SheetVo;
import com.google.common.base.MoreObjects;

public class ReadTest {

	@Test
	public void readExcelTest() throws URISyntaxException {
		// InputStream in = Person.class.getResourceAsStream("/person.xlsx");
		URL url = Person.class.getResource("/person.xlsx");
		File f = new File(url.toURI());

		BingExcel bing = BingExcelBuilder.builderInstance();
		try {
			SheetVo<Person> vo = bing.readFile(f, Person.class, 1);
			System.out.println(vo.getSheetIndex());
			System.out.println(vo.getSheetName());
			System.out.println(vo.getObjectList());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void readExcelTest2() throws URISyntaxException {
		InputStream in = Person.class.getResourceAsStream("/person.xls");
		
		BingExcel bing = BingExcelBuilder.builderInstance();
		try {
			SheetVo<Person> vo = bing.readStream(in, Person.class, 1);
			System.out.println(vo.getSheetIndex());
			System.out.println(vo.getSheetName());
			System.out.println(vo.getObjectList());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static class Person {
		@CellConfig(index = 1)
		private int age;
		//@CellConfig(index = 0,readRequired=true)
		@CellConfig(index = 0)
		private String name;
		@CellConfig(index = 3)
		private Double salary;
		private int gongling;

		public int getGongling() {
			return gongling;
		}

		public void setGongling(int gongling) {
			this.gongling = gongling;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public Double getSalary() {
			return salary;
		}

		public String toString() {
			return MoreObjects.toStringHelper(this.getClass()).omitNullValues()
					.add("name", name).add("age", age).add("salary", salary).add("gl",gongling)
					.toString();
		}
	}
}
