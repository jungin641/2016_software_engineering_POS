package POS_v2;

import POS_v2.domainLayer.*;

public class Main {

	public static void main(String[] args) {
		//start - up (�ʱ⵵���� ��ü ����)
		Store store = new Store();
		Register register = store.getRegister();
		
		//��Ʈ�ѷ���  GUI���� ����
		new ProcessSaleFrame(register);
	}

}
