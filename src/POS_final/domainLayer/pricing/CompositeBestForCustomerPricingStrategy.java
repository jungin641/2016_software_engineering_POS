package POS_final.domainLayer.pricing;

import java.util.Collections;
import java.util.Iterator;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

//최저가 할인 전략
public class CompositeBestForCustomerPricingStrategy extends CompositePricingStrategy {

	public CompositeBestForCustomerPricingStrategy() {
		super();
		
	}

	@Override
	public Money getTotal(Sale s) {
		Money lowestTotal = new Money(Integer.MAX_VALUE);
		for (Iterator i = getPricingStrategies().iterator(); i.hasNext();) {
			ISalePricingStrategy strategy = (ISalePricingStrategy) i.next();
			Money total = strategy.getTotal(s);
			System.out.println(total+"total");
			lowestTotal = total.min(lowestTotal);
		
		}
		System.out.println(lowestTotal+"lowestTotal");
		return lowestTotal;
	}
}
