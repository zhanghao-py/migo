package com.thirdblock.migo.core.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommodityImg implements Serializable {

	private static final long serialVersionUID = 3793159967531346207L;

	private Long id;
	private String url;
	private Long commodityId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	public static List<CommodityImg> createCommodityImgs(String[] fileNames,
			String path, Long commodityId) {
		
		List<CommodityImg> commodityImgs = new ArrayList<CommodityImg>();
		
		for (String fileName : fileNames) {
			CommodityImg c = new CommodityImg();
			c.setUrl(path + fileName);
			c.setCommodityId(commodityId);
			
			commodityImgs.add(c);
		}
		
		return commodityImgs;
	}

}
