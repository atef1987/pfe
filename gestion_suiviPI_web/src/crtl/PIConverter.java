package crtl;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.esprit.gestionPI.dao.PIDaoRemote;
import com.esprit.gestionPI.persistence.PI;

@FacesConverter(value="PIConverter")
public class PIConverter implements Converter {

	PIDaoRemote daoRemote;

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
	   PICtrl ctrl=null;
	   ctrl.getProxy();
		PI piByIntitule = daoRemote.getPIbyIntitule(value);
		return piByIntitule;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value == null || !(value instanceof PI)) {
			return "";
		}

		return ((PI) value).getIntitule().toString();
	}


}
