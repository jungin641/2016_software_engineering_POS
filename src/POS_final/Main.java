package POS_final;

//import POS_final.*;

public class Main {

	public static void main(String[] args) {
		//start - up (�ʱ⵵���� ��ü ����)
		Store store = new Store();
		Register register = store.getRegister();
		
		//��Ʈ�ѷ���  GUI���� ����
		new ProcessSaleJFrame(register);
	}

}
