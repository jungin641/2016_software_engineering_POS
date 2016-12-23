package POS_final.domainLayer.pricing;

import java.util.Iterator;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

//최고가 할인전략
public class CompositeBestForStorePricingStrategy extends CompositePricingStrategy {
	
	public CompositeBestForStorePricingStrategy() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Money getTotal(Sale s) {
		Money higtestTotal = new Money(Integer.MIN_VALUE);
		for (Iterator i = getPricingStrategies().iterator(); i.hasNext();) {
			ISalePricingStrategy strategy = (ISalePricingStrategy) i.next();
			Money total = strategy.getTotal(s);
			higtestTotal = total.max(higtestTotal);
		}
		return higtestTotal;
	}

}
