package POS_final.domainLayer.factory;

import POS_final.domainLayer.tax.GoodAsGoldTaxProAdapter;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;
import POS_final.domainLayer.tax.TaxMasterAdapter;

//��ü ���� ���� Ŭ����
public class ServicesFactory2 {
//�̸� �ڽ��� ��ü�� ����� ���� ���� (�ұ��� �ʱ�ȭ)
	static ServicesFactory2 instance;
	//�����ڸ� private�� ����
	private ServicesFactory2(){
		
	}
	//ServicesFactory��ü�� ��ȯ�ϴ� �޼ҵ�
	//�� �޼ҵ尡 ȣ��Ǹ� �� �� �ڽ��� ��ü�� �����.
	//���� �����尡 ���ÿ� �� �޼ҵ带 ȣ���ϴ� ���, 
	// �� �����常 �� �޼ҵ� ������ ������ �ؾ� �Ѵ�. -> Syncronized�� �ذ�
	static public synchronized ServicesFactory2 getInstance(){
		if(instance == null){ //�� �޼ҵ尡 ó�� ȣ��Ǿ�����...
			//ServicesFactory ���� ���� ���� �� �� �ִ�~
			instance = new ServicesFactory2();
			return instance;
		}
		else
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

