package POS_final.domainLayer.tax;

import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

//Bȸ���� ���� ����
public class GoodAsGoldTaxPro {
	//���ݰ��޼ҵ�
	Money calculateTaxes(Sale s){
		return s.getTotal().times(1.2);
		} //110v
}
