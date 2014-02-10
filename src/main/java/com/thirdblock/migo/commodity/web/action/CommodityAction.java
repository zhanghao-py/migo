package com.thirdblock.migo.commodity.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thirdblock.migo.core.web.action.BaseAction;
import com.thirdblock.migo.core.web.action.dto.StatusInfo;

@Controller
@RequestMapping("commodity")
public class CommodityAction extends BaseAction {
	
	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	@ResponseBody
    public StatusInfo find(@PathVariable Long userId) {
		status.setStatus(StatusInfo.SUCCESS);
		status.setStatusInfo(StatusInfo.SUCCESS_MSG);
        return status;
    }
	
	@RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
	@ResponseBody
    public StatusInfo delete(@PathVariable Long userId) {
		status.setStatus(StatusInfo.SUCCESS);
		status.setStatusInfo(StatusInfo.SUCCESS_MSG);
        return status;
    }
	
	@RequestMapping(value = "", method = RequestMethod.POST) 
	@ResponseBody
    public StatusInfo create(@ModelAttribute Object form) {
		status.setStatus(StatusInfo.SUCCESS);
		status.setStatusInfo(StatusInfo.SUCCESS_MSG);
        return status;
    }
	
	@RequestMapping(value = "{userId}", method = RequestMethod.PUT) 
	@ResponseBody
    public StatusInfo update(@PathVariable Long userId, @ModelAttribute Object form) {
		status.setStatus(StatusInfo.SUCCESS);
		status.setStatusInfo(StatusInfo.SUCCESS_MSG);
        return status;
    }
	
	@RequestMapping(value = "search", method = RequestMethod.POST) 
	@ResponseBody
    public StatusInfo search(@ModelAttribute Object form) {
		status.setStatus(StatusInfo.SUCCESS);
		status.setStatusInfo(StatusInfo.SUCCESS_MSG);
        return status;
    }
}
