package com.thirdblock.migo.account.service.impl;

import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thirdblock.migo.account.dao.ShopDao;
import com.thirdblock.migo.account.service.ShopService;
import com.thirdblock.migo.account.web.action.dto.ShopCreateForm;
import com.thirdblock.migo.account.web.action.dto.ShopSearchForm;
import com.thirdblock.migo.core.bo.Shop;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

@Component
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDao shopDao;

	@Override
	public void saveOrUpdateShop(ShopCreateForm form) throws ServiceException {
		validateShopCreateForm(form);
		
		Shop shop = new Shop(form);
		
		if (ObjectUtils.notEqual(form.getId(), null) && form.getId() > 0L) {
			// TODO:
//			repository.setId(form.getId());
//			repositoryDao.update(repository);
		} else {
			shopDao.save(shop);
		}
		
		return;
		
	}

	private void validateShopCreateForm(ShopCreateForm form) throws ServiceException {
		
		if (StringUtils.isBlank(form.getName())) {
			throw new ServiceException("品牌名称不能为空！");
		}
		
		if (ObjectUtils.equals(form.getMarketId(), null) || form.getMarketId() < 1L) {
			throw new ServiceException("商场不能为空！");
		}
		
		return;
	}

	@Override
	public PageBean<Shop> searchShops(ShopSearchForm form) throws ServiceException {
		
		validateShopSearchForm(form);
		
		PageBean<Shop> page = new PageBean<Shop>();
		page.setPageSize(form.getPageSize());
		page.setCurrentPage(form.getCurrentPage());
		page.setPage(form.isPage());
		
		List<Shop> shops = shopDao.searchShops(form, page);
		
		page.setData(shops);
		
		return page;
		
	}

	private void validateShopSearchForm(ShopSearchForm form) throws ServiceException {
		if (form.getCurrentPage() < 1) {
			throw new ServiceException("搜索页数不能小于1页！");
		}
		
		if (form.getPageSize() < 1) {
			throw new ServiceException("每页大小不能小于1个！");
		}
		
		return;
	}

}
