package POS_final.domainLayer.tax;

import java.util.List;

import POS_final.domainLayer.Sale;

//Aȸ�� ���ݰ��⸦ ���� �����
public class TaxMasterAdapter implements ITaxCalculatorAdapter{
	TaxMaster tm = new TaxMaster();
	
	@Override
	public List getTaxes(Sale s) {
		return tm.calcTax(s);
	}

}
