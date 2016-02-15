package com.bing.excel.reader;

import java.util.List;

import com.bing.excel.exception.BingSaxReadStopException;
import com.bing.excel.reader.vo.CellKV;

public interface ExcelReadListener {
	/**
	 * 该方法自动被调用，每读一行调用一次，在方法中写自己的业务逻辑即可
	 * 
	 * @param sheetIndex
	 *            工作簿序号
	 * @param curRow
	 *            处理到第几行
	 * @param rowList
	 *            当前数据行的数据集合
	 */
	void optRow(int curRow, List<CellKV> rowList);
	void startSheet(int sheetIndex, String name);
	void endSheet(int sheetIndex, String name);
	void endWorkBook();
}
  