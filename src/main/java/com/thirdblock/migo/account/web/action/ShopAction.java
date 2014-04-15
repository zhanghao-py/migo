package com.thirdblock.migo.account.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thirdblock.migo.account.service.ShopService;
import com.thirdblock.migo.account.web.action.dto.ShopCreateForm;
import com.thirdblock.migo.account.web.action.dto.ShopSearchForm;
import com.thirdblock.migo.core.bo.Shop;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;
import com.thirdblock.migo.core.web.action.BaseAction;
import com.thirdblock.migo.core.web.action.dto.StatusInfo;

@Controller
@RequestMapping("account/shop")
public class ShopAction extends BaseAction {
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value = "", method = RequestMethod.POST) 
	@ResponseBody
    public StatusInfo create(@ModelAttribute ShopCreateForm form) {
		
		try {
			shopService.saveOrUpdateShop(form);
		} catch (ServiceException e) {
			logger.warn("", e);
			status.setStatus(StatusInfo.FAILED);
			status.setStatusInfo(e.getMessage());
	        return status;
		}
		
		status.setStatus(StatusInfo.SUCCESS);
		status.setStatusInfo(StatusInfo.SUCCESS_MSG);
		return status;
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST) 
	@ResponseBody
    public StatusInfo search(@ModelAttribute ShopSearchForm form) {
		
		PageBean<Shop> page = null;
		
		try {
			page = shopService.searchShops(form);
		} catch (ServiceException e) {
			logger.warn("", e);
			status.setStatus(StatusInfo.FAILED);
			status.setStatusInfo(e.getMessage());
	        return status;
		}
		
		status.setStatus(StatusInfo.SUCCESS);
		status.setStatusInfo(StatusInfo.SUCCESS_MSG);
		status.setData(page);
		return status;
	}

}
