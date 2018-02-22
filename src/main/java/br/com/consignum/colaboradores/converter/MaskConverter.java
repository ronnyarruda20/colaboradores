package br.com.consignum.colaboradores.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;

@FacesConverter(value = MaskConverter.CONVERTER_ID)
public class MaskConverter implements Converter {

	public static final String CONVERTER_ID = "maskConverter";

	private static final char PAD_CHAR = '0';

	private static final String MAXLENGTH_ATTRIBUTE = "maxlength";

	public Object getAsObject(FacesContext context, UIComponent component, String valor) {

		if (StringUtils.isNotBlank(valor.toString())) {			
			valor = valor.toString().replaceAll("[^0-9]", "");
		}

		return valor;
	}

	public String getAsString(FacesContext context, UIComponent component, Object valor) {

		if (StringUtils.isNotBlank(valor.toString()) && component.getAttributes().containsKey(MAXLENGTH_ATTRIBUTE)) {
			return StringUtils.leftPad(valor.toString(), (Integer) component.getAttributes().get(MAXLENGTH_ATTRIBUTE), PAD_CHAR);
		}

		return valor.toString();

	}
}
