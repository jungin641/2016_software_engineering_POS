package POS_final.domainLayer.pricing;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

//최저가 할인 전략
public class CompositeBestForCustomerPricingStrategy extends CompositePricingStrategy {

	@Override
	public Money getTotal(Sale s) {
		//할인 전략 리스트에 있는 각각의 할인전략을 이용하여
		//할인 가격을 구해서 최저값을 선택한다.	
		return null;
	}

}
