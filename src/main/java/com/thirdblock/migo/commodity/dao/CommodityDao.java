package com.thirdblock.migo.commodity.dao;

import com.thirdblock.migo.core.bo.Commodity;

public interface CommodityDao {

	void update(Commodity commodity);

	void save(Commodity commodity);

	Commodity findById(Long id);

	void deleteById(Long id);

}
