package POS_final.domainLayer.tax;

import java.util.List;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

//���ݰ��Ⱑ �������ϱ� ���Ͻ����ִ� �������̽�
public interface ITaxCalculatorAdapter {
	Money getTaxes(Sale s); //5v
}
