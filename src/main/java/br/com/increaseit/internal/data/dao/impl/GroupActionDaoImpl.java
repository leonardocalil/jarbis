package br.com.increaseit.internal.data.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.increaseit.common.constants.FormFieldAction;
import br.com.increaseit.common.constants.FormFieldType;
import br.com.increaseit.internal.data.dao.IGroupActionDao;
import br.com.increaseit.internal.data.entity.Action;
import br.com.increaseit.internal.data.entity.GroupAction;
import br.com.increaseit.internal.data.entity.Wait;

@Repository
public class GroupActionDaoImpl implements IGroupActionDao {

	public GroupAction getGroupAction() {
		
		List<Action> listAction = new ArrayList<Action>();
		
		GroupAction dto = new GroupAction();
		dto.setUrl("http://www.hotmail.com");
		dto.setActions(listAction);
		
		
		Wait preAction = new Wait();
		
		preAction.setFieldName("buttonLargeBlue");
		preAction.setFieldType(FormFieldType.CLASS);
		preAction.setTimeOut(30);
		
		Action action = new Action();
		
		action.setPreAction(preAction);
		action.setFieldName("buttonLargeBlue");
		action.setFieldType(FormFieldType.CLASS);
		action.setDoAction(FormFieldAction.CLICK);
		
		listAction.add(action);
		
		preAction = new Wait();
		
		preAction.setFieldName("loginfmt");
		preAction.setFieldType(FormFieldType.NAME);
		preAction.setTimeOut(30);
		
		action = new Action();
		
		action.setPreAction(preAction);
		action.setFieldName("loginfmt");
		action.setFieldType(FormFieldType.NAME);
		
		//action.setText("leonardo_calil@hotmail.com");
		action.setDoAction(FormFieldAction.WRITE);
		
		listAction.add(action);
		
		action = new Action();
		
		action.setFieldName("idSIButton9");
		action.setFieldType(FormFieldType.ID);
		
		action.setDoAction(FormFieldAction.CLICK);
		
		listAction.add(action);
		
		preAction = new Wait();
		
		preAction.setFieldName("passwd");
		preAction.setFieldType(FormFieldType.NAME);
		preAction.setTimeOut(30);
		

		action = new Action();
		
		
		action.setPreAction(preAction);
		action.setFieldName("passwd");
		action.setFieldType(FormFieldType.NAME);		
		//action.setText("Leo!841018!");
		action.setDoAction(FormFieldAction.WRITE);
		
		listAction.add(action);
		
		
		action = new Action();
		action.setFieldName("idSIButton9");
		action.setFieldType(FormFieldType.ID);
		
		action.setDoAction(FormFieldAction.CLICK);
		
		listAction.add(action);
		
		
		return dto;
	}
}
