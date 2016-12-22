package POS_final.domainLayer.pricing;

import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;
//몇 퍼센트 할인 전략
public class PercentDiscountPricingStrategy implements ISalePricingStrategy {
	//할인율
	private double percentage = 0;
	
	//생성자
	public PercentDiscountPricingStrategy(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public Money getTotal(Sale s) {
		// TODO Auto-generated method stub
		return s.getCurrentTotal().times(percentage);
	}

}
