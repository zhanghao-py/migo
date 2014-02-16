package com.thirdblock.migo.core.bo;

import java.io.Serializable;

import com.thirdblock.migo.account.web.action.dto.RepositoryCreateForm;

public class Repository implements Serializable {

	private static final long serialVersionUID = -1573175154674097147L;

	private Long id;
	private String name;
	private String description;
	
	public Repository() {}

	public Repository(RepositoryCreateForm form) {
		this.name = form.getName();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
