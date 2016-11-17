package POS_v1;

public class Store {
	private ProductCatalog catalog = new ProductCatalog();
	private Register register = new Register(catalog);
	
	public Register getRegister() {
		return register;
	}
}
