package POS_final.domainLayer;

public class Money {
	private int amount;
	private String unit = "won"; // �޷�, �� ����
	
	public Money (int amount){
		this.amount = amount;
	}
	public Money (){
		//this.amount = 0; // ���ڰ� ������ 0���̴�.
		this(0); // ������ �ȿ����� this�� �����ڸ� ��Ī�Ѵ�.
		
	}
	
	public String toString(){
		return amount + " " +unit;
	}
	public Money times(int number){
	
		return new Money(amount * number);
	}
	public Money times(double number){
		
		return new Money((int) (amount * number));
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
	public boolean isBiggerThan(Money money){
		if (this.amount > money.getAmout())
			return true;
		else
			return false;
	}
	public Money min(Money lowestTotal) {
		if (this.amount <= lowestTotal.getAmout())
			return this;
		else if (this.amount > lowestTotal.getAmout())
			return lowestTotal;
		else	
			return null;
	}
	public Money max(Money highestTotal) {
		if (this.amount <= highestTotal.getAmout())
			return highestTotal;
		else if (this.amount > highestTotal.getAmout())
			return this;
		else 
			return null;
	}
}
