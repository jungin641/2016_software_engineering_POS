package POS_v4;

import POS_v4.domainLayer.*;
import POS_v4.presentaionLayer.ProcessSaleJFrame;

public class Main {

	public static void main(String[] args) {
		//start - up (�ʱ⵵���� ��ü ����)
		Store store = new Store();
		Register register = store.getRegister();
		
		//��Ʈ�ѷ���  GUI���� ����
		new ProcessSaleJFrame(register);
	}

}
