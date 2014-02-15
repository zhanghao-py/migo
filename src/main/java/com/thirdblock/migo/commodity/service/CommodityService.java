package com.thirdblock.migo.commodity.service;

import com.thirdblock.migo.commodity.web.action.dto.CommodityCreateForm;
import com.thirdblock.migo.commodity.web.action.dto.CommoditySearchForm;
import com.thirdblock.migo.core.bo.Commodity;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;
import com.thirdblock.migo.core.web.action.dto.Visitor;

public interface CommodityService {

	void saveOrUpdateCommodity(CommodityCreateForm form, Visitor visitor) throws ServiceException;

	Commodity findCommodityById(Long commodityId) throws ServiceException;

	void deleteCommodityById(Long commodityId) throws ServiceException;

	PageBean<Commodity> searchCommodities(CommoditySearchForm form, Visitor visitor) throws ServiceException;

}
