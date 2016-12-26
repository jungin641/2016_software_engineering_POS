package POS_final.domainLayer.factory;

import POS_final.domainLayer.tax.GoodAsGoldTaxProAdapter;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;
import POS_final.domainLayer.tax.TaxMasterAdapter;

//��ü ���� ���� Ŭ����
public class ServicesFactory {
	private  ITaxCalculatorAdapter taxAdapter;
//�̸� �ڽ��� ��ü�� ����� ���� ���� (�ұ��� �ʱ�ȭ)
	static ServicesFactory instance;
	//�����ڸ� private�� ����
	private ServicesFactory(){
		
	}
	//ServicesFactory��ü�� ��ȯ�ϴ� �޼ҵ�
	//�� �޼ҵ尡 ȣ��Ǹ� �� �� �ڽ��� ��ü�� �����.
	//���� �����尡 ���ÿ� �� �޼ҵ带 ȣ���ϴ� ���, 
	// �� �����常 �� �޼ҵ� ������ ������ �ؾ� �Ѵ�. -> Syncronized�� �ذ�
	public static synchronized ServicesFactory getInstance(){
		if(instance == null){ //�� �޼ҵ尡 ó�� ȣ��Ǿ�����...
			//ServicesFactory ���� ���� ���� �� �� �ִ�~
			instance = new ServicesFactory();
			return instance;
		}
		else
			return instance; 
		//static method�̱� ������ Ŭ������ �����ϱ� ������ ��ü���� ���� ���� -> Static �޼ҵ�� �׻� static �� ���� �� �� �ִ�.
	}
	
	//���ݰ��� ����͸� �����ؼ� ��ȯ�ϴ� �޼ҵ�
	//���ݰ��� ����͸� �����ؼ� ��ȯ�ϴ� �޼ҵ�
		 public ITaxCalculatorAdapter getTaxCalculatorAdapter( ) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
			//���ǳ�Ʈ 26�� 13������
			 //������ ���ݰ��� Ŭ���� �̸���  �ٸ� ������ �����ߴٸ� 
			 //�̰��� �̿��ؼ� ���ݰ��� ����͸� ��������!!
			 //�ٸ������� �����ϴ� ���: �ý��� �Ӽ��� �̿���
			 String className = System.getProperty("taxcalculator.class.name");
			 //className�� �̿��Ͽ� ���ݰ��� ����͸� ����
			 taxAdapter = (ITaxCalculatorAdapter) Class.forName(className).newInstance();
		
			 return taxAdapter;
		}
		
	
}

