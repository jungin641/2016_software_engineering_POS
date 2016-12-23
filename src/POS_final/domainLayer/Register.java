package POS_final.domainLayer;

import POS_final.domainLayer.factory.PricingStrategyFactory;
import POS_final.domainLayer.factory.ServicesFactory;
import POS_final.domainLayer.pricing.ISalePricingStrategy;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;

public class Register {
	private ProductCatalog catalog;
	private Sale currentSale;
	private ITaxCalculatorAdapter taxCalculatorAdapter;
	private ISalePricingStrategy ps;
	
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
	public Money getTotalWithTax(){
		Money totalWithTax = new Money();
		try {
			taxCalculatorAdapter = ServicesFactory.getInstance().getTaxCalculatorAdapter();
			totalWithTax = taxCalculatorAdapter.getTaxes(currentSale);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		currentSale.setTotal(totalWithTax);
		return totalWithTax;
	}
	public PricingStrategyFactory getPricingStrategyFactory(){
		return PricingStrategyFactory.getInstance();
	}
	
}
