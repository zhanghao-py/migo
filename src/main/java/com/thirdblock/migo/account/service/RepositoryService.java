package com.thirdblock.migo.account.service;

import com.thirdblock.migo.account.web.action.dto.RepositoryCreateForm;
import com.thirdblock.migo.account.web.action.dto.RepositorySearchForm;
import com.thirdblock.migo.core.bo.Repository;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

public interface RepositoryService {

	void saveOrUpdateRepository(RepositoryCreateForm form) throws ServiceException;

	PageBean<Repository> searchRepositories(RepositorySearchForm form) throws ServiceException;

}
