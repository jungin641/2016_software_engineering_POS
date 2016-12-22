package POS_final.domainLayer.pricing;

import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;
//�� �ۼ�Ʈ ���� ����
public class PercentDiscountPricingStrategy implements ISalePricingStrategy {
	//������
	private double percentage = 0;
	
	//������
	public PercentDiscountPricingStrategy(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public Money getTotal(Sale s) {
		// TODO Auto-generated method stub
		return s.getCurrentTotal().times(percentage);
	}

}
