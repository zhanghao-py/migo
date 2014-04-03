package com.thirdblock.migo.commodity.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.thirdblock.migo.core.bo.CommodityImg;
import com.thirdblock.migo.test.SpringTransactionalIntegrationTestCase;

public class CommodityImgDaoTest extends SpringTransactionalIntegrationTestCase {
	
	@Autowired
	private CommodityImgDao commodityImgDao;
	
	@Test
	@Rollback(false)
	public void itShouldSaveBatch() {
		String fileNames[] = {"zhanghao1.jpg", "zhanghao2.jpg", "zhanghao3.jpg"};
		String path = "/img/";
		long commodityId = 5L;
		
		List<CommodityImg> commodityImgs = CommodityImg.createCommodityImgs(fileNames, path, commodityId);
		commodityImgDao.saveBatch(commodityImgs);
	}

}
