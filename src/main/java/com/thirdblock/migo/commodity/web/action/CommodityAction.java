package com.thirdblock.migo.commodity.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thirdblock.migo.core.web.action.BaseAction;

@Controller
@RequestMapping("commodity")
public class CommodityAction extends BaseAction {

	/*
	@RequestMapping(value = "create", method = RequestMethod.POST) 
    public ModelAndView create() {
        return new ModelAndView("index");
    }
	
	@RequestMapping(value = "delete", method = RequestMethod.DELETE) 
    public ModelAndView delete() {
        return new ModelAndView("index");
    }
	
	@RequestMapping(value = "update", method = RequestMethod.PUT) 
    public ModelAndView update() {
        return new ModelAndView("index");
    }
	
	@RequestMapping(value = "find", method = RequestMethod.GET) 
    public ModelAndView find() {
        return new ModelAndView("index");
    }
	
	@RequestMapping(value = "list", method = RequestMethod.GET) 
    public ModelAndView list() {
        return new ModelAndView("index");
    }
    */
}
