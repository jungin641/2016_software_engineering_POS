package POS_final.domainLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import POS_final.domainLayer.factory.PricingStrategyFactory;
import POS_final.domainLayer.factory.ServicesFactory;
import POS_final.domainLayer.pricing.CompositePricingStrategy;
import POS_final.domainLayer.pricing.ISalePricingStrategy;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;

public class Sale {
	private List<SalesLineItem> lineItems = new ArrayList<SalesLineItem>();
	private Date date = new Date(); //현재 시각
	private boolean isComplete = false;
	private Payment payment;
	private Money total;
	private ISalePricingStrategy pricingStrategy;
	
	public void Sale(){
		
	}
	public Money getBalance(){ //?��?�� 
		return payment.getAmount().minus(applyDiscount());
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
	public Money applyDiscount(){ 
		Money totalAfterDiscount = new Money();
		pricingStrategy = PricingStrategyFactory.getInstance().getSalePricingStrategy();
		totalAfterDiscount = pricingStrategy.getTotal(this);
		return totalAfterDiscount;
		
	}
//	Money totalWithTax = new Money();
//	try {
//		taxCalculatorAdapter = ServicesFactory.getInstance().getTaxCalculatorAdapter();
//		totalWithTax = taxCalculatorAdapter.getTaxes(currentSale);
//	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//		e.printStackTrace();
//	}
//	currentSale.setTotal(totalWithTax);
//	return totalWithTax;

}

