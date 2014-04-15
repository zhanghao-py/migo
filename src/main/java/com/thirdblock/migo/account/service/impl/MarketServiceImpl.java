package com.thirdblock.migo.account.service.impl;

import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thirdblock.migo.account.dao.MarketDao;
import com.thirdblock.migo.account.service.MarketService;
import com.thirdblock.migo.account.web.action.dto.MarketCreateForm;
import com.thirdblock.migo.account.web.action.dto.MarketSearchForm;
import com.thirdblock.migo.core.bo.Market;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

@Component
public class MarketServiceImpl implements MarketService {

	@Autowired
	private MarketDao marketDao;
	
	@Override
	public void saveOrUpdateMarket(MarketCreateForm form) throws ServiceException {
		validateMarketCreateForm(form);
		
		Market market = new Market(form);
		
		if (ObjectUtils.notEqual(form.getId(), null) && form.getId() > 0L) {
			// TODO:
//			repository.setId(form.getId());
//			repositoryDao.update(repository);
		} else {
			marketDao.save(market);
		}
		
		return;		
	}
	
	private void validateMarketCreateForm(MarketCreateForm form) throws ServiceException {
		
		if (StringUtils.isBlank(form.getName())) {
			throw new ServiceException("商场名称不能为空！");
		}
		
		return;
	}
	
	@Override
	public PageBean<Market> searchMarkets(MarketSearchForm form) throws ServiceException {
		
		validateMarketSearchForm(form);
		
		PageBean<Market> page = new PageBean<Market>();
		page.setPageSize(form.getPageSize());
		page.setCurrentPage(form.getCurrentPage());
		page.setPage(form.isPage());
		
		List<Market> markets = marketDao.searchMarkets(form, page);
		
		page.setData(markets);
		
		return page;
		
	}

	private void validateMarketSearchForm(MarketSearchForm form) throws ServiceException {
		if (form.getCurrentPage() < 1) {
			throw new ServiceException("搜索页数不能小于1页！");
		}
		
		if (form.getPageSize() < 1) {
			throw new ServiceException("每页大小不能小于1个！");
		}
		
		return;
	}

}
