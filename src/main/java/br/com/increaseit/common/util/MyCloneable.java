package br.com.increaseit.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


import br.com.increaseit.common.util.Constants;

public abstract class MyCloneable<T> implements Cloneable{
	
	protected abstract Class<?> getInstance();
	
	private List<Field> listAllFields(Class<?> obj) {
		Class<?> stopWhenClass = Object.class;	
	    
		List<Field> fieldList = new ArrayList<Field>();
	    while (obj != null && !obj.equals(stopWhenClass)) {
	    	for (Field field : obj.getDeclaredFields()) {
	    		if(!Constants.getInstance().getIgnoreFields().contains(field.getName())) {
	    			fieldList.add(field);
	    		}
	    	}
	    	obj = obj.getSuperclass();
	    }
	    return fieldList;
	}
	private Field getField(Class<?> targetObj, Field origField) {
		Class<?> stopWhenClass = Object.class;	
	    
		while (targetObj != null && !targetObj.equals(stopWhenClass)) {
	    	for (Field field : targetObj.getDeclaredFields()) {
	    		System.out.println(field.getName());
	    		if (field.getType().equals(origField.getType()) && field.getName().equals(origField.getName())) {
	    			return field; 
	    		}
	    	}
	    	targetObj = targetObj.getSuperclass();
	    }
	    return null;
	}
	
	public void copyTo(T target) {
		List<Field> fieldList = listAllFields(getInstance());
		
		for (Field field : fieldList) {
			
			field.setAccessible(true);
			try {
				
				Object valueObj = copyObject(field.get(getInstance()));
				
				if (valueObj != null) {
					
					Field newObjectField = getField(target.getClass(), field);
					newObjectField.setAccessible(true);
					newObjectField.set(target, valueObj);
					
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		
		}
	}
	
	
	
	private Object copyObject(Object obj) {

		try {
			
			if (obj == null ) {
				return null;
			}
			if (obj instanceof String) {
				return new String((String) obj);
			}
			if (obj instanceof Integer) {
				return new Integer((Integer) obj);
			}
			if (obj instanceof Long) {
				return new Long((Long) obj);
			}
			if (obj instanceof Boolean) {
				return new Boolean((Boolean) obj);
			}
			
			if (obj instanceof List) {
				
				List<Object> listNewObject = new ArrayList<>();
				
				for (Object value : (List<?>)obj) {
					listNewObject.add(copyObject(value));
				}
				
				return listNewObject;
			}
			if (obj instanceof Enum) {
				
				return obj.getClass().newInstance();
			}
//			if (obj instanceof Cloneable) {
//				return ObjectUtils.clone(obj);
//			}
			
			Object newObject = obj.getClass().newInstance();
			
			List<Field> fieldList = listAllFields(obj.getClass());
			
			for (Field field : fieldList) {
				if (field.isAccessible()) {
					Object valueObj = copyObject(field.get(obj));
					
					if (valueObj != null) {
						
						Field newObjectField = newObject.getClass().getField(field.getName());
						newObjectField.set(newObject, valueObj);
						
					}	
				}
			
			}
			
			return newObject;
			
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T clone() throws CloneNotSupportedException {
		return (T) super.clone();		    
    }
	
}
