package POS_final.domainLayer.pricing;

import java.util.ArrayList;
import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

//������ ���� ������ ����Ʈ�� �����ϴ� Ŭ����
public abstract class CompositePricingStrategy implements ISalePricingStrategy {
	
	//�������� ����Ʈ
	// protected  �ڽĵ��� ������ �� �ֵ��� ��
	protected List<ISalePricingStrategy> pricingStrategies = new ArrayList<ISalePricingStrategy>();
	
	// �� ���� ������ �߰��ϴ� �޼ҵ�
	public void add(ISalePricingStrategy s){
		pricingStrategies.add(s);
	}
	@Override
	//���� �� ������ ����ϴ� �޼ҵ� - �߻�޼ҵ�!
	public abstract Money getTotal(Sale s);

}
