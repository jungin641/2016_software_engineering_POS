package POS_final.domainLayer;

public class Money {
	private int amount;
	private String unit = "won"; // 달러, 원 단위
	
	public Money (int amount){
		this.amount = amount;
	}
	public Money (){
		//this.amount = 0; // 인자가 없을땐 0원이다.
		this(0); // 생성자 안에서의 this는 생성자를 지칭한다.
		
	}
	
	public String toString(){
		return amount + " " +unit;
	}
	public Money times(int number){
	
		return new Money(amount * number);
	}
	public Money minus(Money money) {
		
		return new Money(this.amount - money.getAmout()) ;
	}
	private int getAmout() {
		// TODO Auto-generated method stub
		return amount;
	}
	public void add(Money money) {
		this.amount += money.getAmout();
		
	}
}
