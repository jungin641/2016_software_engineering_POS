package POS_v0;

public class ProductCatalog {
	private Map<ItemID, ProductDescription> descriptions = new HashMap()<ItemID,ProductDescription>;
	
	public ProductCatalog(){
		//견본 데이터
		ItemID id1= new ItemID(100);
		ItemID id2= new ItemID(200);
		Money price = new Money(3);
		
		ProductDescription desc;
		
		desc = new ProductDescription(id1, price, "product 1");
		descriptions.put(id1, desc);
		
		desc = new ProductDescription(id2, price, "product 2");
		descriptions.put(id2, desc);
		
	}
	
	public ProductDescription getProductDescription(ItemID id){
		
		return descriptions.getItemID(id);
	}
}
