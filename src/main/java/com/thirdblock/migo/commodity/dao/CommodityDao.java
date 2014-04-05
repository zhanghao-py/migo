package com.thirdblock.migo.commodity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thirdblock.migo.commodity.web.action.dto.SearchCommoditiesVO;
import com.thirdblock.migo.commodity.web.action.dto.CommoditySearchForm;
import com.thirdblock.migo.core.bo.Commodity;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

public interface CommodityDao {

	void update(Commodity commodity);

	void save(Commodity commodity);

	Commodity findById(Long id);

	void deleteById(Long id);

	List<SearchCommoditiesVO> searchCommodities(@Param("form") CommoditySearchForm form,
			@Param("respositoryId") Long respositoryId, @Param("page") PageBean<SearchCommoditiesVO> page);

}
