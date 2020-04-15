package br.com.increaseit.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.increaseit.backend.service.GroupActionService;
import br.com.increaseit.internal.data.dao.IGroupActionDao;
import br.com.increaseit.internal.data.entity.GroupAction;


@Service
public class GroupActionServiceImpl implements GroupActionService{

	@Autowired
	private IGroupActionDao dao;
	
	public GroupAction getGroupAction() {
		return dao.getGroupAction();
	}

}
