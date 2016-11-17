package POS_v1;

public class SalesLineItem {
	private int quantity;
	private ProductDescription description;
	
	public SalesLineItem(ProductDescription desc, int quantity){
		this.description = desc;
		this.quantity = quantity;
	}
	public Money getSubtotal(){
		//������ ���� ���ϱ� ����
		return description.getPrice().times(quantity);
	}
}
