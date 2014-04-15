package com.thirdblock.migo.core.bo;

import java.io.Serializable;

import com.thirdblock.migo.account.web.action.dto.MarketCreateForm;

public class Market implements Serializable {

	private static final long serialVersionUID = 674109968596432166L;

	private Long id;
	private String name;
	private String telephone;
	private String address;
	private String description;
	
	public Market() {}

	public Market(MarketCreateForm form) {
		this.name = form.getName();
		this.telephone = form.getTelephone();
		this.address = form.getAddress();
		this.description = form.getDescription();
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
