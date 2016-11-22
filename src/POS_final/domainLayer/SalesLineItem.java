package POS_final.domainLayer;

public class SalesLineItem {
	private int quantity;
	private ProductDescription description;
	
	public SalesLineItem(ProductDescription desc, int quantity){
		this.description = desc;
		this.quantity = quantity;
	}
	public Money getSubtotal(){
		//물건의 가격 곱하기 수량
		return description.getPrice().times(quantity);
	}
}
