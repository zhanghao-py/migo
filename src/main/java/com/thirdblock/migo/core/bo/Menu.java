package com.thirdblock.migo.core.bo;

import java.io.Serializable;

public class Menu implements Serializable{

	private static final long serialVersionUID = 4017472645249133112L;

	public final static String ROOT = "ROOT";
	
	private Long id;
	private String name;
	private Long parentId;
	private String auth;

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

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

}
