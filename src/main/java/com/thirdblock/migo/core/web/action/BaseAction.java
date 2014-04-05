package com.thirdblock.migo.core.web.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.thirdblock.migo.account.service.UserService;
import com.thirdblock.migo.core.bo.User;
import com.thirdblock.migo.core.web.action.dto.StatusInfo;
import com.thirdblock.migo.core.web.action.dto.Visitor;

public class BaseAction {

	protected Logger logger = Logger.getLogger(getClass());
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	protected StatusInfo status = new StatusInfo();
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession(true);
	}
	
	protected Visitor getVisitor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Visitor visitor = null;
		
		if (authentication.isAuthenticated()) {

			String username = authentication.getName();
			User user = userService.findUserByUsername(username);
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
			
			visitor = new Visitor();
			visitor.setId(user.getId());
			visitor.setUsername(user.getUsername());
			visitor.setRespositoryId(user.getRepositoryId());
			visitor.setAuthorities(authorities);
		}
		
		return visitor;
	}
	
}
