package com.thirdblock.migo.commodity.dao;

import java.util.List;

import com.thirdblock.migo.core.bo.CommodityImg;

public interface CommodityImgDao {

	void saveBatch(List<CommodityImg> commodityImgs);
	void deleteByCommodityId(Long commodityId);

}
