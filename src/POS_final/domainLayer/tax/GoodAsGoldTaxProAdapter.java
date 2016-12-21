package POS_final.domainLayer.tax;

import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

public class GoodAsGoldTaxProAdapter implements ITaxCalculatorAdapter {
	GoodAsGoldTaxPro gagtp = new GoodAsGoldTaxPro();
	
	@Override
	public Money getTaxes(Sale s) {
		return gagtp.calculateTaxes(s);
	}

}
