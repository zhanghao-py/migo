package com.thirdblock.migo.core.auth.web.action;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thirdblock.migo.core.web.action.BaseAction;
import com.thirdblock.migo.core.web.action.dto.StatusInfo;

@Controller  
@RequestMapping("")
public class RestAuthenticationAction extends BaseAction {

	@RequestMapping(value = "authenticationFailure", method = RequestMethod.POST) 
	@ResponseBody
    public StatusInfo authenticationFailure() {
		
		AuthenticationException exception = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		
		status.setStatusInfo(exception.getMessage());
		status.setStatus(StatusInfo.FAILED);
		
        return status;
    }
	
	@RequestMapping(value = "authenticationSuccess", method = RequestMethod.POST) 
	@ResponseBody
    public StatusInfo authenticationSuccess() {
		
		status.setStatusInfo("Authentication success");
		status.setStatus(StatusInfo.SUCCESS);
		
        return status;
    }
	
	@RequestMapping(value = "logoutSuccess", method = RequestMethod.GET) 
	@ResponseBody
    public StatusInfo logoutSuccess() {
		
		status.setStatusInfo("Logout success");
		status.setStatus(StatusInfo.SUCCESS);
		
        return status;
    }
	
	@RequestMapping(value = "unauthorized", method = { RequestMethod.GET, RequestMethod.POST }) 
	@ResponseBody
    public StatusInfo unauthorized() {
		
		status.setStatusInfo("Logout success");
		status.setStatus(StatusInfo.SUCCESS);
		
        return status;
	}
	
	@RequestMapping(value = "accessDenied", method = RequestMethod.GET) 
	@ResponseBody
    public StatusInfo accessDenied() {
		
		status.setStatusInfo("Logout success");
		status.setStatus(StatusInfo.SUCCESS);
		
        return status;
	}
	
	

}
