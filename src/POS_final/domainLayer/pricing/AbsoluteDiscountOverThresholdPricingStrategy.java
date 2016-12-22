package POS_final.domainLayer.pricing;

import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;
//얼마 넘으면 얼마 깎아주는 할인 전략

public class AbsoluteDiscountOverThresholdPricingStrategy implements ISalePricingStrategy {
	// 얼마 넘으면
	private Money threshold;
	//얼마 할인
	private Money discount;


	public AbsoluteDiscountOverThresholdPricingStrategy(Money threshold, Money discount) {
		
		this.threshold = threshold;
		this.discount = discount;
	}

	@Override
	public Money getTotal(Sale s) {
		if(s.getCurrentTotal().isBiggerThan(threshold))
			return s.getCurrentTotal().minus(discount);
		else
			return s.getCurrentTotal();
	}

}
