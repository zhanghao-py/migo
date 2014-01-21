package com.thirdblock.migo.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thirdblock.migo.account.dao.ResourceDao;
import com.thirdblock.migo.account.service.ResourceService;
import com.thirdblock.migo.core.bo.Resource;

@Component("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;
	
	@Override
	public List<Resource> findAllResources() {
		return resourceDao.findAllResources();
	}

}
