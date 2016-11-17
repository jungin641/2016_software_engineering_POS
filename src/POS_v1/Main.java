package POS_v1;

public class Main {

	public static void main(String[] args) {
		//start - up (�ʱ⵵���� ��ü ����)
		Store store = new Store();
		
		//��Ʈ�ѷ� ���
		Register register = store.getRegister();
		
		//��ƲȦ������ �޽��� ������
		
		//1. makeNewSale() Sale��ü�� ���� ���ü��� �������� ��
		Sale sale = register.makeNewSale();
		//2. enterItem()
		//����� 1000�� 5���� 5000��
		register.enterItem(new ItemID(100), 5); //����� �ټ�������
		//������ ������ 2����
		register.enterItem(new ItemID(200), 10); //�黩�� ��������
		//3. endSale()
		register.endSale();
		//4.makePayment()
		register.makePayment(new Money(30000)); // ���� 3������ ��
		//�� �����ϴ��� �˻�  �ܵ��� 5000������ Ȯ��
		//Sale���� ���� ���
		System.out.println(sale.getTotal()+"");
		System.out.println(sale.getBalance()+"");
		
		
	}

}
