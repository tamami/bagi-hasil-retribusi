package lab.aikibo.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;

public class NumberFormatConverter implements Converter {

	@Override
	public Object coerceToUi(Object beanProp, Component component,
			BindContext ctx) {
		if(!(beanProp instanceof BigDecimal)) {
			return beanProp;
		}
		
		final NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		
		return nf.format(beanProp);
	}

	@Override
	public Object coerceToBean(Object compAttr, Component component,
			BindContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
