package com.thirdblock.migo.account.service;

import com.thirdblock.migo.account.web.action.dto.RepositoryCreateForm;
import com.thirdblock.migo.core.excep.ServiceException;

public interface RepositoryService {

	void saveOrUpdateRepository(RepositoryCreateForm form) throws ServiceException;

}
