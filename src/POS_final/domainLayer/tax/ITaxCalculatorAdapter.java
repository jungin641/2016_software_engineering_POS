package POS_final.domainLayer.tax;

import java.util.List;

import POS_final.domainLayer.Sale;

//세금계산기가 여러개니까 통일시켜주는 인터페이스
public interface ITaxCalculatorAdapter {
	List getTaxes(Sale s); //5v
}
