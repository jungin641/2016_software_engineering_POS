package POS_final.domainLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import POS_final.domainLayer.factory.ServicesFactory;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;

public class Sale {
	private List<SalesLineItem> lineItems = new ArrayList<SalesLineItem>();
	private Date date = new Date(); //현재 시각
	private boolean isComplete = false;
	private Payment payment;
	private Money total;
	
	public Money getBalance(){ //?��?�� 
		return payment.getAmount().minus(getTotal());
	}
	public void becomeComplete(){
		isComplete = true;
	}
	public boolean isComplete(){
		return isComplete;
	}
	
	public void makeLineItem(ProductDescription desc, int quantity){
		lineItems.add(new SalesLineItem(desc, quantity));
	}
	
	public Money getTotal(){
		Money total = new Money();
		Money subtotal = null;
		
		for(SalesLineItem lineItem : lineItems){
			subtotal = lineItem.getSubtotal();
			total.add(subtotal);
		}
		this.total = total;
		return total;
	}
	public void setTotal(Money total){
		this.total = total;
	}
	public Money getCurrentTotal(){
		return this.total;
	}
	
	public void makePayment(Money cashTendered){
		payment  = new Payment(cashTendered);
	}
	
}

