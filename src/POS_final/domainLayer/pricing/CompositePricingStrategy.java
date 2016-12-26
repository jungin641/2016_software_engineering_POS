package POS_final.domainLayer.pricing;

import java.util.ArrayList;
import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

//������ ���� ������ ����Ʈ�� �����ϴ� Ŭ����
public abstract class CompositePricingStrategy implements ISalePricingStrategy {
	// �������� ����Ʈ
	// protected �ڽĵ��� ������ �� �ֵ��� ��
	protected List<ISalePricingStrategy> pricingStrategies = new ArrayList<ISalePricingStrategy>();

	public CompositePricingStrategy() {
		
		// ���� ����
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

	// �� ���� ������ �߰��ϴ� �޼ҵ�
	public void add(ISalePricingStrategy s) {
		getPricingStrategies().add(s);
	}

	@Override
	// ���� �� ������ ����ϴ� �޼ҵ� - �߻�޼ҵ�!
	public abstract Money getTotal(Sale s);

	public List<ISalePricingStrategy> getPricingStrategies() {
		return pricingStrategies;
	}

	public void setPricingStrategies(List<ISalePricingStrategy> pricingStrategies) {
		this.pricingStrategies = pricingStrategies;
	}

}
