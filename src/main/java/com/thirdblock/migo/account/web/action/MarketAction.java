package com.thirdblock.migo.account.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thirdblock.migo.account.service.MarketService;
import com.thirdblock.migo.account.web.action.dto.MarketCreateForm;
import com.thirdblock.migo.account.web.action.dto.MarketSearchForm;
import com.thirdblock.migo.core.bo.Market;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;
import com.thirdblock.migo.core.web.action.BaseAction;
import com.thirdblock.migo.core.web.action.dto.StatusInfo;

@Controller
@RequestMapping("account/market")
public class MarketAction extends BaseAction {
	
	@Autowired
	private MarketService marketService;
	
	@RequestMapping(value = "", method = RequestMethod.POST) 
	@ResponseBody
    public StatusInfo create(@ModelAttribute MarketCreateForm form) {
		
		try {
			marketService.saveOrUpdateMarket(form);
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
    public StatusInfo search(@ModelAttribute MarketSearchForm form) {
		
		PageBean<Market> page = null;
		
		try {
			page = marketService.searchMarkets(form);
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
