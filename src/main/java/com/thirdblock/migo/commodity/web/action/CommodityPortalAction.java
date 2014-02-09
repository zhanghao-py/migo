package com.thirdblock.migo.commodity.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thirdblock.migo.core.web.action.BaseAction;

@Controller
@RequestMapping("commodity")
public class CommodityPortalAction extends BaseAction {

	@RequestMapping(value = "create", method = RequestMethod.GET) 
    public ModelAndView create() {
        return new ModelAndView("commodity/create");
    }
	
	@RequestMapping(value = "list", method = RequestMethod.GET) 
    public ModelAndView list() {
        return new ModelAndView("commodity/list");
    }
}
