package POS_final.domainLayer.factory;

import POS_final.domainLayer.tax.GoodAsGoldTaxProAdapter;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;
import POS_final.domainLayer.tax.TaxMasterAdapter;

//��ü ���� ���� Ŭ����
public class ServicesFactory {
//�̸� �ڽ��� ��ü�� ����� ���� (������ �ʱ�ȭ) - �̸� ����� ���Ҵ�
	static ServicesFactory instance = new ServicesFactory();
	//�����ڸ� private�� ����
	private ServicesFactory(){
		
	}
	//ServicesFactory��ü�� ��ȯ�ϴ� �޼ҵ�
	static public ServicesFactory getInstance(){
		return instance; 
		//static method�̱� ������ Ŭ������ �����ϱ� ������ ��ü���� ���� ���� -> Static �޼ҵ�� �׻� static �� ���� �� �� �ִ�.
	}
	
	//���ݰ��� ����͸� �����ؼ� ��ȯ�ϴ� �޼ҵ�
	 public ITaxCalculatorAdapter getTaxCalculatorAdapter( ) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//		if( ){
//		//1) TaxMAster ���ݰ��� �̿� �� 
//		return new TaxMasterAdapter();
//		}
//		else {
//		// 2)Gold ���ݰ��� �̿��
//		return new GoodAsGoldTaxProAdapter();}
		 
		//���ǳ�Ʈ 26�� 13������
		 //������ ���ݰ��� Ŭ���� �̸���  �ٸ� ������ �����ߴٸ� 
		 //�̰��� �̿��ؼ� ���ݰ��� ����͸� ��������!!
		 //�ٸ������� �����ϴ� ���: �ý��� �Ӽ��� �̿���
		 String className = System.getProperty("taxcalculator.class.name");
		 //className�� �̿��Ͽ� ���ݰ��� ����͸� ����
		 ITaxCalculatorAdapter taxAdapter = (ITaxCalculatorAdapter) Class.forName(className).newInstance();
		 
		 return taxAdapter;
	}
	 
	 
}
