package br.com.increaseit.frontend.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.increaseit.internal.data.entity.GroupAction;


@FacesConverter(value="groupActionConverter", forClass = GroupAction.class)
public class GroupActionConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {

		if (value != null && !value.isEmpty()) {
            return (GroupAction) uiComponent.getAttributes().get(value);
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof GroupAction) {
			GroupAction entity= (GroupAction) value;
            if (entity != null && entity instanceof GroupAction && entity.getRowId() != null) {
                uiComponent.getAttributes().put( entity.getRowId().toString(), entity);
                return entity.getRowId().toString();
            }
        }
        return "";
	}
}
