package com.thirdblock.migo.core.auth.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thirdblock.migo.core.web.action.BaseAction;

@Controller
@RequestMapping("")
public class AuthPortalAction extends BaseAction {
	
	@RequestMapping(value = "login", method = RequestMethod.GET) 
    public ModelAndView login() {
        return new ModelAndView("signin");
    }
	
	@RequestMapping(value = "index", method = RequestMethod.GET) 
    public ModelAndView index() {
        return new ModelAndView("index");
    }
	
	@RequestMapping(value = "page403", method = RequestMethod.GET) 
    public ModelAndView page403() {
        return new ModelAndView("page403");
    }

}
