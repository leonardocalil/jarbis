package br.com.increaseit.frontend.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.increaseit.internal.data.entity.Action;


@FacesConverter(value="actionConverter", forClass = Action.class)
public class ActionConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {

		if (value != null && !value.isEmpty()) {
            return (Action) uiComponent.getAttributes().get(value);
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof Action) {

			
			Action entity= (Action) value;
            if (entity != null && entity instanceof Action && entity.getRowId() != null) {
                uiComponent.getAttributes().put( entity.getRowId().toString(), entity);
                return entity.getRowId().toString();
            }
        }
        return "";
	}

}
