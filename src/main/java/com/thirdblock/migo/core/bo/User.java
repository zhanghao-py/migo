package com.thirdblock.migo.core.bo;

import java.io.Serializable;

import com.thirdblock.migo.account.web.action.dto.UserCreateForm;

public class User implements Serializable {

	private static final long serialVersionUID = -8138447347176260275L;

	private Long id;
	private String username;
	private String password;
	private Boolean enabled;
	private Long repositoryId;
	
	public User() {}
	
	public User(UserCreateForm form) {
		this.username = form.getUsername();
		this.password = form.getPassword();
		this.enabled = Boolean.TRUE;
		this.repositoryId = form.getRepositoryId();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Long getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(Long repositoryId) {
		this.repositoryId = repositoryId;
	}
	
}
