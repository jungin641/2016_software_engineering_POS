package POS_final.domainLayer;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
//	private Map<ItemID, ProductDescription> descriptions = new HashMap<ItemID,ProductDescription>();
	private Map<String, ProductDescription> descriptions = new HashMap<String,ProductDescription>();
	
	public ProductCatalog(){
		//�ߺ� ������
		ItemID id1= new ItemID(100); // �����
		Money price1 = new Money(1000);
		
		ItemID id2= new ItemID(200); // ������
		Money price2 = new Money(2000);
		
		//�ߺ������� ���
		ProductDescription desc;
		
		desc = new ProductDescription(id1, price1, "�����");
		descriptions.put(id1.toString(), desc); //key value
		
		desc = new ProductDescription(id2, price2, "������");
		descriptions.put(id2.toString(), desc);
		
	}
	
	public ProductDescription getProductDescription(ItemID id){
		//�˻��� �ȵż� nullpointerexception �� :  ItemID ������ int������ �ٲ��� �� toString ���� �ٲ�
		return descriptions.get(id.toString()); // key
	}
}
