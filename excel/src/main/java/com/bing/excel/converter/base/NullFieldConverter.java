package com.bing.excel.converter.base;

import com.bing.excel.converter.AbstractFieldConvertor;

@Deprecated
public final class NullFieldConverter extends AbstractFieldConvertor {

	@Override
	public boolean canConvert(Class<?> clz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object fromString(Object cell) {
		// TODO Auto-generated method stub
		return null;
	}

}
