package POS_v2.domainLayer;

public class Register {
	private ProductCatalog catalog;
	private Sale currentSale;
	
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
	
}
