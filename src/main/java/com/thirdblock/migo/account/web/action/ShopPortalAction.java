package com.thirdblock.migo.account.web.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thirdblock.migo.account.service.MarketService;
import com.thirdblock.migo.account.web.action.dto.MarketSearchForm;
import com.thirdblock.migo.core.bo.Market;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;
import com.thirdblock.migo.core.web.action.BaseAction;

@Controller
@RequestMapping("account/shop")
public class ShopPortalAction extends BaseAction {
	
	@Autowired
	private MarketService marketService;
	
	@RequestMapping(value = "create", method = RequestMethod.GET) 
    public ModelAndView create() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		MarketSearchForm form = new MarketSearchForm();
		form.setPage(Boolean.FALSE);
		
		try {
			PageBean<Market> page = marketService.searchMarkets(form);
			model.put("markets", page.getData());
		} catch (ServiceException e) {
			logger.warn("", e);
			return new ModelAndView();
		}
		
        return new ModelAndView("account/new-shop", model);
    }
	
	@RequestMapping(value = "list", method = RequestMethod.GET) 
    public ModelAndView list() {
        return new ModelAndView("account/shop-list");
    }

}
