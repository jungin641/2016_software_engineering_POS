package POS_final.domainLayer.pricing;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.*;

// ���� ������ ��ǥ�ϴ� �������̽�
public interface ISalePricingStrategy {
	public Money getTotal(Sale s);
	
}
