package com.thirdblock.migo.commodity.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thirdblock.migo.commodity.dao.CommodityDao;
import com.thirdblock.migo.commodity.service.CommodityService;
import com.thirdblock.migo.commodity.web.action.dto.CommodityCreateForm;
import com.thirdblock.migo.commodity.web.action.dto.CommoditySearchForm;
import com.thirdblock.migo.core.bo.Commodity;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;
import com.thirdblock.migo.core.web.action.dto.Visitor;

@Component
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;
	
	@Override
	public void saveOrUpdateCommodity(CommodityCreateForm form, Visitor visitor) throws ServiceException {
		validateCommodityCreateForm(form);
		
		Commodity commodity = new Commodity(form);
		commodity.setUserId(visitor.getId());
		
		if (ObjectUtils.notEqual(form.getId(), null) && form.getId() > 0L) {
			commodity.setId(form.getId());
			commodity.setCreateTime(new Date());
			commodityDao.update(commodity);
		} else {
			commodity.setCreateTime(new Date());
			commodityDao.save(commodity);
		}
		
		return;
	}

	private void validateCommodityCreateForm(CommodityCreateForm form) throws ServiceException {
		
		if (StringUtils.isBlank(form.getName())) {
			throw new ServiceException("商品名称不能为空！");
		}
		
		if (StringUtils.isBlank(form.getDescription())) {
			throw new ServiceException("商品描述不能为空！");
		}
		
		if (ObjectUtils.equals(form.getCategoryId(), null) || form.getCategoryId() < 1L) {
			throw new ServiceException("商品分类不能为空！");
		}
		
		if (form.getPrice() == null || form.getPrice().compareTo(BigDecimal.ONE) < 0) {
			throw new ServiceException("会员价不能为空, 不能小于一元钱！");
		}
		
		if (form.getOriginalPrice() == null || form.getOriginalPrice().compareTo(BigDecimal.ONE) < 0) {
			throw new ServiceException("参考价不能为空, 不能小于一元钱！");
		}
		
		if (StringUtils.isBlank(form.getDetail())) {
			throw new ServiceException("商品详细信息不能为空！");
		}
		
		return;
		
	}

	@Override
	public Commodity findCommodityById(Long commodityId) throws ServiceException {
		
		if (ObjectUtils.equals(commodityId, null) || commodityId < 1L) {
			throw new ServiceException("商品id不能为空！");
		}
		
		return commodityDao.findById(commodityId);
	}

	@Override
	public void deleteCommodityById(Long commodityId) throws ServiceException {
		if (ObjectUtils.equals(commodityId, null) || commodityId < 1L) {
			throw new ServiceException("商品id不能为空！");
		}
		
		commodityDao.deleteById(commodityId);
	}

	@Override
	public PageBean<Commodity> searchCommodities(CommoditySearchForm form,
			Visitor visitor) throws ServiceException {
		
		validateCommoditySearchForm(form);
		
		PageBean<Commodity> page = new PageBean<Commodity>();
		page.setPageSize(form.getPageSize());
		page.setCurrentPage(form.getCurrentPage());
		
		List<Commodity> commodities = commodityDao.searchCommodities(form, page);
		
		page.setData(commodities);
		
		return page;
	}

	private void validateCommoditySearchForm(CommoditySearchForm form) throws ServiceException {
		
		if (form.getCurrentPage() < 1) {
			throw new ServiceException("搜索页数不能小于1页！");
		}
		
		if (form.getPageSize() < 1) {
			throw new ServiceException("每页大小不能小于1个！");
		}
		
		return;
	}

}
