package com.thirdblock.migo.commodity.web.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thirdblock.migo.category.service.CategoryService;
import com.thirdblock.migo.core.web.action.BaseAction;

@Controller
@RequestMapping("commodity")
public class CommodityPortalAction extends BaseAction {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "create", method = RequestMethod.GET) 
    public ModelAndView create() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("categoryTree", categoryService.getCategoryTree());
        return new ModelAndView("commodity/create", model);
    }
	
	@RequestMapping(value = "list", method = RequestMethod.GET) 
    public ModelAndView list() {
        return new ModelAndView("commodity/list");
    }
}
