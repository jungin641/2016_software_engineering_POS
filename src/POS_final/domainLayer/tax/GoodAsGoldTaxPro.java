package POS_final.domainLayer.tax;

import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

//B회사의 세금 계산기
public class GoodAsGoldTaxPro {
	//세금계산메소드
	Money calculateTaxes(Sale s){
		return s.getTotal().times(1.2);
		} //110v
}
