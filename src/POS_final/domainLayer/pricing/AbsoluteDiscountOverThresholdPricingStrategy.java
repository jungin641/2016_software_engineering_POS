package POS_final.domainLayer.pricing;

import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;
//�� ������ �� ����ִ� ���� ����

public class AbsoluteDiscountOverThresholdPricingStrategy implements ISalePricingStrategy {
	// �� ������
	private Money threshold;
	//�� ����
	private Money discount;


	public AbsoluteDiscountOverThresholdPricingStrategy(Money threshold, Money discount) {
		
		this.threshold = threshold;
		this.discount = discount;
	}

	@Override
	public Money getTotal(Sale s) {
		// TODO Auto-generated method stub
		return null;
	}

}
