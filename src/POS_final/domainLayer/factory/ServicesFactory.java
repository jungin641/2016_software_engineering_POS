package POS_final.domainLayer.factory;

import POS_final.domainLayer.tax.GoodAsGoldTaxProAdapter;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;
import POS_final.domainLayer.tax.TaxMasterAdapter;

//��ü ���� ���� Ŭ����
public class ServicesFactory {
	
	//���ݰ��� ����͸� �����ؼ� ��ȯ�ϴ� �޼ҵ�
	 public ITaxCalculatorAdapter getTaxCalculatorAdapter( ) {
		if( ){
		//1) TaxMAster ���ݰ��� �̿� �� 
		return new TaxMasterAdapter();
		}
		else {
		// 2)Gold ���ݰ��� �̿��
		return new GoodAsGoldTaxProAdapter();}
	}
	 
	 //���ǳ�Ʈ 26�� 13������
	 //������ ���ݰ��� Ŭ���� �̸���  �ٸ� ������ �����ߴٸ� 
	 //�̰��� �̿��ؼ� ���ݰ��� ����͸� ��������!!
	 //�ٸ������� �����ϴ� ���: �ý��� �Ӽ��� �̿���
	 String className = System.getProperty("taxcalculator.class.name");
	 //className�� �̿��Ͽ� ���ݰ��� ����͸� ����
	 ITaxCalculatorAdapter taxAdapter = (ITaxCalculatorAdapter) Class.forName(className).newInstance();
	 
	 return taxAdapter;
}

