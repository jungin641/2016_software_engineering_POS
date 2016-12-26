package POS_final.domainLayer;

public class Store{
	private ProductCatalog catalog;
	private Register register;
	public Store(String databseDriver, String databseURL) {
		catalog = new ProductCatalog(databseDriver,databseURL);
		register = new Register(catalog);

	}

		
	public Register getRegister() {
		return register;
	}
}
