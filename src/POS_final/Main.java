package POS_final;

import POS_final.domainLayer.Register;
import POS_final.domainLayer.Store;
import POS_final.domainLayer.factory.ServicesFactory;
import POS_final.domainLayer.tax.GoodAsGoldTaxProAdapter;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;
import POS_final.domainLayer.tax.TaxMasterAdapter;
import POS_final.presentaionLayer.*;

//import POS_final.*;

public class Main {

	public static void main(String[] args) {
		//start - up (초기도메인 객체 생성)
		Store store = new Store();
		Register register = store.getRegister();
		
		//컨트롤러를  GUI에게 전달
		new ProcessSaleJFrame(register);
		
		//생성할 세금계산기 어댑터 종류를시스템 속성을 이용하여 지정
		System.setProperty("taxcalculator.class.name", "POS_final.domainLayer.tax.GoodAsGoldTaxProAdapter");
		//System.setProperty("taxcalculator.class.name", "TaxMasterAdapter");
		
		//System - > 자바 프로그램이 실행되는 환경
		
		//세금계산기 이용
		//***부모타입의 변수는,여러 종류의 자식 타입의 객체를 가리킬 수 있다.
		ITaxCalculatorAdapter taxCalculator;
		
		//26.4절 : 어떤 종류의 세금계산기를 생성할지 결정해야함 
		// => factory 클래스에게 맡기자
//		//1) TaxMAster 세금계산기 이용 시 
//		taxCalculator = new TaxMasterAdapter();
//	
//		// 2)Gold 세금계산기 이용시
//		taxCalculator = new GoodAsGoldTaxProAdapter();
		
		//세금계산기 어댑터 생성을 ServicesFactory에게 부탁
		taxCalculator = (new ServicesFactory()).getTaxCalculatorAdapter();
		
		//세금 계산 요청 (세금계산기 종류에 상관 없음)
		taxCalculator.getTaxes(s);
	}

}
