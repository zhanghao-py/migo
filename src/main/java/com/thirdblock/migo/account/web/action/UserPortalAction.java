package com.thirdblock.migo.account.web.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thirdblock.migo.account.service.ShopService;
import com.thirdblock.migo.account.web.action.dto.ShopSearchForm;
import com.thirdblock.migo.core.bo.Shop;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;
import com.thirdblock.migo.core.util.UsernameKeyGenerator;
import com.thirdblock.migo.core.web.action.BaseAction;

@Controller
@RequestMapping("account/user")
public class UserPortalAction extends BaseAction {
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET) 
    public ModelAndView list() {
        return new ModelAndView("account/user-list");
    }
	
	@RequestMapping(value = "create", method = RequestMethod.GET) 
    public ModelAndView create() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		ShopSearchForm form = new ShopSearchForm();
		form.setPage(Boolean.FALSE);
		
		try {
			PageBean<Shop> page = shopService.searchShops(form);
			model.put("shops", page.getData());
			model.put("username", UsernameKeyGenerator.getKey());
		} catch (ServiceException e) {
			logger.warn("", e);
			return new ModelAndView();
		}
		
        return new ModelAndView("account/new-user", model);
    }
	
	@RequestMapping(value = "profile", method = RequestMethod.GET) 
    public ModelAndView profile() {
        return new ModelAndView("account/user-profile");
    }

}
