package POS_v1;

public class Main {

	public static void main(String[] args) {
		//start - up (초기도메인 객체 생성)
		Store store = new Store();
		
		//콘트롤러 얻기
		Register register = store.getRegister();
		
		//컨틀홀러에게 메시지 보내기
		
		//1. makeNewSale() Sale객체를 만들어서 가시성을 가지도록 함
		Sale sale = register.makeNewSale();
		//2. enterItem()
		//새우깡 1000원 5봉지 5000원
		register.enterItem(new ItemID(100), 5); //새우깡 다섯봉지쓰
		//빼빼로 열봉지 2만원
		register.enterItem(new ItemID(200), 10); //백빼로 열봉지쓰
		//3. endSale()
		register.endSale();
		//4.makePayment()
		register.makePayment(new Money(30000)); // 고객이 3만원을 냄
		//잘 동작하는지 검사  잔돈이 5000원인지 확인
		//Sale에게 직접 물어봄
		System.out.println(sale.getTotal()+"");
		System.out.println(sale.getBalance()+"");
		
		
	}

}
