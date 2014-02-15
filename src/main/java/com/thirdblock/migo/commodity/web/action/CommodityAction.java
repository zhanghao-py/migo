package com.thirdblock.migo.commodity.web.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thirdblock.migo.commodity.service.CommodityService;
import com.thirdblock.migo.commodity.web.action.dto.CommodityCreateForm;
import com.thirdblock.migo.commodity.web.action.dto.CommoditySearchForm;
import com.thirdblock.migo.core.bo.Commodity;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;
import com.thirdblock.migo.core.web.action.BaseAction;
import com.thirdblock.migo.core.web.action.dto.StatusInfo;

@Controller
@RequestMapping("commodity")
public class CommodityAction extends BaseAction {
	
	private Logger logger = Logger.getLogger(CommodityAction.class);
	
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping(value = "{commodityId}", method = RequestMethod.GET)
	@ResponseBody
    public StatusInfo find(@PathVariable Long commodityId) {
		
		Commodity commodity = null;
		try {
			commodity = commodityService.findCommodityById(commodityId);
		} catch (ServiceException e) {
			logger.warn("", e);
			status.setStatus(StatusInfo.FAILED);
			status.setStatusInfo(e.getMessage());
			return status;
		}
		
		status.setStatus(StatusInfo.SUCCESS);
		status.setStatusInfo(StatusInfo.SUCCESS_MSG);
		status.setData(commodity);
        return status;
    }
	
	@RequestMapping(value = "{commodityId}", method = RequestMethod.DELETE)
	@ResponseBody
    public StatusInfo delete(@PathVariable Long commodityId) {
		
		try {
			commodityService.deleteCommodityById(commodityId);
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
	
	@RequestMapping(value = "", method = RequestMethod.POST) 
	@ResponseBody
    public StatusInfo create(@ModelAttribute CommodityCreateForm form) {
		try {
			commodityService.saveOrUpdateCommodity(form, getVisitor());
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
	
	@RequestMapping(value = "", method = RequestMethod.PUT) 
	@ResponseBody
    public StatusInfo update(@ModelAttribute CommodityCreateForm form) {
		try {
			commodityService.saveOrUpdateCommodity(form, getVisitor());
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
    public StatusInfo search(@ModelAttribute CommoditySearchForm form) {
		
		PageBean<Commodity> page = null;
		try {
			page = commodityService.searchCommodities(form, getVisitor());
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
