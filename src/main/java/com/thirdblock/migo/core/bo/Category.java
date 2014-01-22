package com.thirdblock.migo.core.bo;

import java.io.Serializable;

public class Category implements Serializable{

	public final static String ROOT = "ROOT";
	
	private static final long serialVersionUID = 5621777900637529976L;
	
	private Long id;
	private String name;
	private Long parentId;

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
