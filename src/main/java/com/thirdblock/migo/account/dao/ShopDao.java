package com.thirdblock.migo.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thirdblock.migo.account.web.action.dto.ShopSearchForm;
import com.thirdblock.migo.core.bo.Shop;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

public interface ShopDao {

	void update(Shop shop);

	void save(Shop shop);

	List<Shop> searchShops(ShopSearchForm form,
			@Param("page") PageBean<Shop> page);

}
