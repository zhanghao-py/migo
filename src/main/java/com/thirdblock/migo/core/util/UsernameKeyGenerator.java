package com.thirdblock.migo.core.util;

import org.apache.commons.lang.time.DateFormatUtils;

public class UsernameKeyGenerator {
	
	/**
	 * 生成用户名, 日期yyyyMMddHHmmssSSS
	 * @return
	 */
	public static String getKey() {
		String keyPrefix = "migo";
		String keyPostfix = DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmssSSS");
		String key = keyPrefix + keyPostfix;
		return key;
	}

}
