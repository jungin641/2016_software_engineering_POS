package POS_final.domainLayer;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
//	private Map<ItemID, ProductDescription> descriptions = new HashMap<ItemID,ProductDescription>();
	private Map<String, ProductDescription> descriptions = new HashMap<String,ProductDescription>();
	
	public ProductCatalog(){
		//°ßº» µ¥ÀÌÅÍ
		ItemID id1= new ItemID(100); // »õ¿ì±ø
		Money price1 = new Money(1000);
		
		ItemID id2= new ItemID(200); // »©»©·Î
		Money price2 = new Money(2000);
		
		//°ßº»µ¥ÀÌÅÍ µî·Ï
		ProductDescription desc;
		
		desc = new ProductDescription(id1, price1, "»õ¿ì±ø");
		descriptions.put(id1.toString(), desc); //key value
		
		desc = new ProductDescription(id2, price2, "»©»©·Î");
		descriptions.put(id2.toString(), desc);
		
	}
	
	public ProductDescription getProductDescription(ItemID id){
		//°Ë»öÀÌ ¾ÈµÅ¼­ nullpointerexception ¶ä :  ItemID Çü¿¡¼­ intÇüÀ¸·Î ¹Ù²ãÁØ ÈÄ toString À¸·Î ¹Ù²Þ
		return descriptions.get(id.toString()); // key
	}
}
