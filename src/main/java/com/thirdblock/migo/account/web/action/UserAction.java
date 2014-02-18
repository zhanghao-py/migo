package com.thirdblock.migo.account.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thirdblock.migo.account.service.UserService;
import com.thirdblock.migo.account.web.action.dto.SearchUsersVO;
import com.thirdblock.migo.account.web.action.dto.UserCreateForm;
import com.thirdblock.migo.account.web.action.dto.UserSearchForm;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;
import com.thirdblock.migo.core.web.action.BaseAction;
import com.thirdblock.migo.core.web.action.dto.StatusInfo;

@Controller
@RequestMapping("account/user")
public class UserAction extends BaseAction {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.POST) 
	@ResponseBody
    public StatusInfo create(@ModelAttribute UserCreateForm form) {
		try {
			userService.saveOrUpdateUser(form);
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
    public StatusInfo search(@ModelAttribute UserSearchForm form) {
		
		PageBean<SearchUsersVO> page = null;
		
		try {
			page = userService.searchUsers(form);
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
