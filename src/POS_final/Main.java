package POS_final;

//import POS_final.*;

public class Main {

	public static void main(String[] args) {
		//start - up (초기도메인 객체 생성)
		Store store = new Store();
		Register register = store.getRegister();
		
		//컨트롤러를  GUI에게 전달
		new ProcessSaleJFrame(register);
	}

}
