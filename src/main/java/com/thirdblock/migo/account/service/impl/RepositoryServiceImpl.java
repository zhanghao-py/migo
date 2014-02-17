package com.thirdblock.migo.account.service.impl;

import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thirdblock.migo.account.dao.RepositoryDao;
import com.thirdblock.migo.account.service.RepositoryService;
import com.thirdblock.migo.account.web.action.dto.RepositoryCreateForm;
import com.thirdblock.migo.account.web.action.dto.RepositorySearchForm;
import com.thirdblock.migo.core.bo.Repository;
import com.thirdblock.migo.core.excep.ServiceException;
import com.thirdblock.migo.core.mybatis.pagination.PageBean;

@Component
public class RepositoryServiceImpl implements RepositoryService {
	
	@Autowired
	private RepositoryDao repositoryDao;

	@Override
	public void saveOrUpdateRepository(RepositoryCreateForm form) throws ServiceException {
		validateRepositoryCreateForm(form);
		
		Repository repository = new Repository(form);
		
		if (ObjectUtils.notEqual(form.getId(), null) && form.getId() > 0L) {
			// TODO:
//			repository.setId(form.getId());
//			repositoryDao.update(repository);
		} else {
			repositoryDao.save(repository);
		}
		
		return;
		
	}

	private void validateRepositoryCreateForm(RepositoryCreateForm form) throws ServiceException {
		
		if (StringUtils.isBlank(form.getName())) {
			throw new ServiceException("用户组名称不能为空！");
		}
		
		return;
	}

	@Override
	public PageBean<Repository> searchRepositories(RepositorySearchForm form) throws ServiceException {
		
		validateRepositorySearchForm(form);
		
		PageBean<Repository> page = new PageBean<Repository>();
		page.setPageSize(form.getPageSize());
		page.setCurrentPage(form.getCurrentPage());
		
		List<Repository> repositories = repositoryDao.searchRepositories(form, page);
		
		page.setData(repositories);
		
		return page;
		
	}

	private void validateRepositorySearchForm(RepositorySearchForm form) throws ServiceException {
		if (form.getCurrentPage() < 1) {
			throw new ServiceException("搜索页数不能小于1页！");
		}
		
		if (form.getPageSize() < 1) {
			throw new ServiceException("每页大小不能小于1个！");
		}
		
		return;
		
	}

}
