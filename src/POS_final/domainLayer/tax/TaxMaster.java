package POS_final.domainLayer.tax;

import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

//A회사의 세금 계산기
public class TaxMaster {
	//세금 계산 메소드
	Money calcTax(Sale s){
		return s.getTotal().times(1.1);
		
	} //220v
}
