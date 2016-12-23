package POS_final;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Register;
import POS_final.domainLayer.Sale;
import POS_final.domainLayer.Store;
import POS_final.domainLayer.factory.ServicesFactory_j;
import POS_final.domainLayer.pricing.*;
import POS_final.domainLayer.tax.GoodAsGoldTaxProAdapter;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;
import POS_final.domainLayer.tax.TaxMasterAdapter;
import POS_final.presentaionLayer.*;
import POS_final.domainLayer.*;
//import POS_final.*;

public class Main {

	public static void main(String[] args) {
		// start - up (�ʱ⵵���� ��ü ����)
		Store store = new Store();
		Register register = store.getRegister();

		// ��Ʈ�ѷ��� GUI���� ����
		new ProcessSaleJFrame(register);
		
		// System.setProperty("taxcalculator.class.name", "TaxMasterAdapter");

		// System - > �ڹ� ���α׷��� ����Ǵ� ȯ��

		// ���ݰ��� �̿�
		// ***�θ�Ÿ���� ������,���� ������ �ڽ� Ÿ���� ��ü�� ����ų �� �ִ�.
//		ITaxCalculatorAdapter taxCalculator;

		// 26.4�� : � ������ ���ݰ��⸦ �������� �����ؾ���
		// => factory Ŭ�������� �ñ���
		// //1) TaxMAster ���ݰ��� �̿� ��
		// taxCalculator = new TaxMasterAdapter();
		//
		// // 2)Gold ���ݰ��� �̿��
//		 taxCalculator = new GoodAsGoldTaxProAdapter();

		// ���ݰ��� ����� ������ ServicesFactory���� ��Ź
		// taxCalculator = (new ServicesFactory()).getTaxCalculatorAdapter();
		// ServicesFactory ��ü�� ����
		// new ServicesFactory(); �� ����
//		ServicesFactory_j factory = ServicesFactory_j.getInstance();
//
//		// ���� ��� ��û (���ݰ��� ������ ��� ����)
//		taxCalculator.getTaxes(s);
//		
		
		
	}

}
