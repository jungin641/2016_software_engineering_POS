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
//run: sun.jdbc.odbc.JdbcOdbcDriver jdbc:odbc:POS

public class Main {

	public static void main(String[] args) {
		// start - up (�ʱ⵵���� ��ü ����)
		Store store = new Store(args[0],args[1]);
		Register register = store.getRegister();

		// ��Ʈ�ѷ��� GUI���� ����
		new ProcessSaleJFrame(register);
		
	
		
		
	}

}
