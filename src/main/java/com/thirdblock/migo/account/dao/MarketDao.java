package com.thirdblock.migo.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thirdblock.migo.account.web.action.dto.MarketSearchForm;
import com.thirdblock.migo.core.bo.Market;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

public interface MarketDao {

	void update(Market market);

	void save(Market market);
	
	List<Market> searchMarkets(MarketSearchForm form,
			@Param("page") PageBean<Market> page);

}
