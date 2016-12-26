package POS_final.domainLayer.factory;

import POS_final.domainLayer.tax.GoodAsGoldTaxProAdapter;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;
import POS_final.domainLayer.tax.TaxMasterAdapter;

//��ü ���� ���� Ŭ����
public class ServicesFactory_j {
	private static ITaxCalculatorAdapter taxAdapter;
//�̸� �ڽ��� ��ü�� ����� ���� (������ �ʱ�ȭ) - �̸� ����� ���Ҵ�
	static ServicesFactory_j instance = new ServicesFactory_j();
	//�����ڸ� private�� ����
	private ServicesFactory_j(){
		
	}
	//ServicesFactory��ü�� ��ȯ�ϴ� �޼ҵ�
	static public ServicesFactory_j getInstance(){
		return instance; 
		//static method�̱� ������ Ŭ������ �����ϱ� ������ ��ü���� ���� ���� -> Static �޼ҵ�� �׻� static �� ���� �� �� �ִ�.
	}
	
	//���ݰ��� ����͸� �����ؼ� ��ȯ�ϴ� �޼ҵ�
	 public static synchronized ITaxCalculatorAdapter getTaxCalculatorAdapter( ) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		 if ( taxAdapter == null ){
		//���ǳ�Ʈ 26�� 13������
		 //������ ���ݰ��� Ŭ���� �̸���  �ٸ� ������ �����ߴٸ� 
		 //�̰��� �̿��ؼ� ���ݰ��� ����͸� ��������!!
		 //�ٸ������� �����ϴ� ���: �ý��� �Ӽ��� �̿���
		 String className = System.getProperty("taxcalculator.class.name");
		 //className�� �̿��Ͽ� ���ݰ��� ����͸� ����
		 taxAdapter = (ITaxCalculatorAdapter) Class.forName(className).newInstance();
		 }
		 return taxAdapter;
	}
	 
	 
}

