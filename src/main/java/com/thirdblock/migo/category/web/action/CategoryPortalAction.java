package com.thirdblock.migo.category.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thirdblock.migo.core.web.action.BaseAction;

@Controller
@RequestMapping("category")
public class CategoryPortalAction extends BaseAction {

	/*
	@RequestMapping(value = "list", method = RequestMethod.GET) 
    public ModelAndView list() {
        return new ModelAndView("category/list");
    }
    */
}
