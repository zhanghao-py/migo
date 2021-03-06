package com.thirdblock.migo.account.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thirdblock.migo.core.web.action.BaseAction;

@Controller
@RequestMapping("account/market")
public class MarketPortalAction extends BaseAction {
	
	@RequestMapping(value = "create", method = RequestMethod.GET) 
    public ModelAndView create() {
        return new ModelAndView("account/new-market");
    }
	
	@RequestMapping(value = "list", method = RequestMethod.GET) 
    public ModelAndView list() {
        return new ModelAndView("account/market-list");
    }

}
