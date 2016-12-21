package POS_final.domainLayer;

import POS_final.domainLayer.factory.ServicesFactory;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;

public class Register {
	private ProductCatalog catalog;
	private Sale currentSale;
	private ITaxCalculatorAdapter taxCalculatorAdapter;
	
	public Register(ProductCatalog catalog){
		this.catalog = catalog;
		
	}
	public void endSale(){
		currentSale.becomeComplete();
	}
	public void enterItem(ItemID id, int quantity){
		ProductDescription desc = catalog.getProductDescription(id);
		currentSale.makeLineItem(desc, quantity);
	}
	public Sale makeNewSale(){
		currentSale = new Sale();
		return currentSale;
	}
	public void makePayment(Money cashTendered){
		currentSale.makePayment(cashTendered);
	}
	public int getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Money calculateTax(){
		Money afterCalcTax = null;
		try {
			taxCalculatorAdapter = ServicesFactory.getInstance().getTaxCalculatorAdapter();
			afterCalcTax = taxCalculatorAdapter.getTaxes(currentSale);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return afterCalcTax;
	}
	
}
