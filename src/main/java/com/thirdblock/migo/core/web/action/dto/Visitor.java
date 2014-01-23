package com.thirdblock.migo.core.web.action.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class Visitor {

	private Long id;
	private String username;
	private Collection<GrantedAuthority> authorities;

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

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
}
