package com.thirdblock.migo.account.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("account/user")
public class UserPortalAction {
	
	@RequestMapping(value = "list", method = RequestMethod.GET) 
    public ModelAndView list() {
        return new ModelAndView("account/user-list");
    }
	
	@RequestMapping(value = "create", method = RequestMethod.GET) 
    public ModelAndView create() {
        return new ModelAndView("account/new-user");
    }
	
	@RequestMapping(value = "profile", method = RequestMethod.GET) 
    public ModelAndView profile() {
        return new ModelAndView("account/user-profile");
    }

}
