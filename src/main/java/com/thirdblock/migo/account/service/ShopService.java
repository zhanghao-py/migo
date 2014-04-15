package com.thirdblock.migo.account.service;

import com.thirdblock.migo.account.web.action.dto.ShopCreateForm;
import com.thirdblock.migo.account.web.action.dto.ShopSearchForm;
import com.thirdblock.migo.core.bo.Shop;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

public interface ShopService {

	void saveOrUpdateShop(ShopCreateForm form) throws ServiceException;

	PageBean<Shop> searchShops(ShopSearchForm form) throws ServiceException;

}
