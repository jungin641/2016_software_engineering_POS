package POS_final.domainLayer.pricing;

import java.util.ArrayList;
import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

//각각의 할인 전략을 리스트로 관리하는 클래스
public abstract class CompositePricingStrategy implements ISalePricingStrategy {
	// 할인전략 리스트
	// protected 자식들이 접근할 수 있도록 함
	protected List<ISalePricingStrategy> pricingStrategies = new ArrayList<ISalePricingStrategy>();

	public CompositePricingStrategy() {
		
		// 가격 할인
		ISalePricingStrategy percentageStrategy1 = (ISalePricingStrategy) new PercentDiscountPricingStrategy(0.2);
		ISalePricingStrategy percentageStrategy2 = (ISalePricingStrategy) new PercentDiscountPricingStrategy(0.1);
		
		ISalePricingStrategy absoluteStrategy1 = (ISalePricingStrategy) new AbsoluteDiscountOverThresholdPricingStrategy(
				new Money(20000), new Money(1000));
		ISalePricingStrategy absoluteStrategy2 = (ISalePricingStrategy) new AbsoluteDiscountOverThresholdPricingStrategy(
				new Money(15000), new Money(500));

		
		pricingStrategies.add(percentageStrategy1);
		pricingStrategies.add(percentageStrategy2);
		pricingStrategies.add(absoluteStrategy1);
		pricingStrategies.add(absoluteStrategy2);
		

	}

	// 각 할인 전략을 추가하는 메소드
	public void add(ISalePricingStrategy s) {
		getPricingStrategies().add(s);
	}

	@Override
	// 할인 후 가격을 계산하는 메소드 - 추상메소드!
	public abstract Money getTotal(Sale s);

	public List<ISalePricingStrategy> getPricingStrategies() {
		return pricingStrategies;
	}

	public void setPricingStrategies(List<ISalePricingStrategy> pricingStrategies) {
		this.pricingStrategies = pricingStrategies;
	}

}
