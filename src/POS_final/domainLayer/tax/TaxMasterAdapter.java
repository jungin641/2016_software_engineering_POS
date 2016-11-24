package POS_final.domainLayer.tax;

import java.util.List;

import POS_final.domainLayer.Sale;

//A회사 세금계산기를 위한 어댑터
public class TaxMasterAdapter implements ITaxCalculatorAdapter{
	TaxMaster tm = new TaxMaster();
	
	@Override
	public List getTaxes(Sale s) {
		return tm.calcTax(s);
	}

}
