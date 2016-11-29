package POS_final.domainLayer.pricing;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.*;

// 할인 전략을 대표하는 인터페이스
public interface ISalePricingStrategy {
	public Money getTotal(Sale s);
	
}
