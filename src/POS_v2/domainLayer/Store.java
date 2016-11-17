package POS_v2.domainLayer;

public class Store {
	private ProductCatalog catalog = new ProductCatalog();
	private Register register = new Register(catalog);
	
	public Register getRegister() {
		return register;
	}
}
