package POS_final.domainLayer.factory;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.pricing.AbsoluteDiscountOverThresholdPricingStrategy;
import POS_final.domainLayer.pricing.CompositeBestForCustomerPricingStrategy;
import POS_final.domainLayer.pricing.CompositeBestForStorePricingStrategy;
import POS_final.domainLayer.pricing.CompositePricingStrategy;
import POS_final.domainLayer.pricing.ISalePricingStrategy;
import POS_final.domainLayer.pricing.PercentDiscountPricingStrategy;

//���� ���� ���� ��ü�� �����ϴ� Ŭ����
public class PricingStrategyFactory {

	private static final int BestForCustomer = 1;
	private static final int BestForStore = 2;
	private static int currentStrategyType = 0;
	private static ISalePricingStrategy salePricingStrategy;
	private static PricingStrategyFactory instance;

	private PricingStrategyFactory() {

	}

	public static synchronized PricingStrategyFactory getInstance() {
		if (instance == null) {
			instance = new PricingStrategyFactory();
			return instance;
		} else
			return instance;
	}

	// ���� ������ü�� ��ȯ�ϴ� �޼ҵ�
	public static synchronized ISalePricingStrategy getSalePricingStrategy() {
		if (currentStrategyType == BestForCustomer) {
			salePricingStrategy = new CompositeBestForCustomerPricingStrategy();
			return salePricingStrategy;
		} else if (currentStrategyType == BestForStore) {
			salePricingStrategy = new CompositeBestForStorePricingStrategy();
			return salePricingStrategy;
		} else
			return null;
	}

	public void setPricingStrategyType(int strategyType) {
		currentStrategyType = strategyType;
	}

}
