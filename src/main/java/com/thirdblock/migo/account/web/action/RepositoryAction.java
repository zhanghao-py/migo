package com.thirdblock.migo.account.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thirdblock.migo.account.service.RepositoryService;
import com.thirdblock.migo.account.web.action.dto.RepositoryCreateForm;
import com.thirdblock.migo.account.web.action.dto.RepositorySearchForm;
import com.thirdblock.migo.core.bo.Repository;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;
import com.thirdblock.migo.core.web.action.BaseAction;
import com.thirdblock.migo.core.web.action.dto.StatusInfo;

@Controller
@RequestMapping("account/repository")
public class RepositoryAction extends BaseAction {
	
	@Autowired
	private RepositoryService repositoryService;
	
	@RequestMapping(value = "", method = RequestMethod.POST) 
	@ResponseBody
    public StatusInfo create(@ModelAttribute RepositoryCreateForm form) {
		
		try {
			repositoryService.saveOrUpdateRepository(form);
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
    public StatusInfo search(@ModelAttribute RepositorySearchForm form) {
		
		PageBean<Repository> page = null;
		
		try {
			page = repositoryService.searchRepositories(form);
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
