package POS_final.domainLayer.tax;

import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

//Aȸ���� ���� ����
public class TaxMaster {
	//���� ��� �޼ҵ�
	Money calcTax(Sale s){
		return s.getTotal().times(1.1);
		
	} //220v
}
