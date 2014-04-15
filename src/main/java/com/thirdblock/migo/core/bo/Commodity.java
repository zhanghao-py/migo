package com.thirdblock.migo.core.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.thirdblock.migo.commodity.web.action.dto.CommodityCreateForm;

public class Commodity implements Serializable {

	private static final long serialVersionUID = 7051339463177492785L;

	private Long id;
	private String name;
	private String description;
	private Long categoryId;
	private BigDecimal price;
	private BigDecimal originalPrice;
	private String detail;
	private Date createTime;
	private Date updateTime;
	private Long shopId;
	private Boolean isDelete;
	
	public Commodity() {}

	public Commodity(CommodityCreateForm form) {
		this.name = form.getName();
		this.description = form.getDescription();
		this.categoryId = form.getCategoryId();
		this.price = form.getPrice();
		this.originalPrice = form.getOriginalPrice();
//		this.detail = form.getDetail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	
}
