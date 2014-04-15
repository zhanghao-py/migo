package com.thirdblock.migo.account.service;

import com.thirdblock.migo.account.web.action.dto.MarketCreateForm;
import com.thirdblock.migo.account.web.action.dto.MarketSearchForm;
import com.thirdblock.migo.core.bo.Market;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

public interface MarketService {

	void saveOrUpdateMarket(MarketCreateForm form) throws ServiceException;

	PageBean<Market> searchMarkets(MarketSearchForm form) throws ServiceException;

}
