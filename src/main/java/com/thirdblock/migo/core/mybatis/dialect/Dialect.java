package com.thirdblock.migo.core.mybatis.dialect;

/**
 * 
 * @author zhanghao10@baidu.com
 *
 */
public interface Dialect {

	public abstract String getPageSQL(String sql, int offset, int limit);
}
