package com.bing.excel.core;


import com.bing.common.Builder;
import com.bing.excel.converter.FieldValueConverter;
import com.bing.excel.core.handler.ConverterHandler;
import com.bing.excel.core.handler.LocalConverterHandler;
import com.bing.excel.core.impl.BingExcelImpl;

/**
 * <p>
 * Title: BingExcelBuilder<／p>
 * <p>
 * Description: <code>BingExcel</code>的构造类，可以添加自定义转换器等。<／p>
 * <p>
 * Company: bing<／p>
 * 
 * @author zhongtao.shi
 * @date 2015-12-8
 */
/**
 * <p>
 * Title: BingExcelBuilder<／p>
 * <p>
 * Description: <／p>
 * <p>
 * Company: bing<／p>
 * 
 * @author zhongtao.shi
 * @date 2015-12-8
 */
public class BingExcelBuilder implements Builder<BingExcel> {
	private final ConverterHandler localConverterHandler = new LocalConverterHandler();
	/**
	 * bingExcel:对应的excel工具类。
	 */
	private BingExcel bingExcel;

	/**
	 * <p>
	 * Title: <／p>
	 * <p>
	 * Description: 构造新的builder对象<／p>
	 */
	private BingExcelBuilder() {

	}

	public static Builder<BingExcel> toBuilder() {

		return new BingExcelBuilder();

	}
	@Override
	public Builder<BingExcel> registerFieldConverter(Class<?> clazz,
			FieldValueConverter converter) {
		localConverterHandler.registerConverter(clazz, converter);
		return this;
	}

	@Override
	public BingExcel builder() {
		if (bingExcel == null) {
			bingExcel = new BingExcelImpl(localConverterHandler);
		}

		return this.bingExcel;
	}

}
