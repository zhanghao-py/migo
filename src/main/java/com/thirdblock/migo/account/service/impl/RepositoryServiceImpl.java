package com.thirdblock.migo.account.service.impl;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thirdblock.migo.account.dao.RepositoryDao;
import com.thirdblock.migo.account.service.RepositoryService;
import com.thirdblock.migo.account.web.action.dto.RepositoryCreateForm;
import com.thirdblock.migo.core.bo.Repository;
import com.thirdblock.migo.core.excep.ServiceException;

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

}
