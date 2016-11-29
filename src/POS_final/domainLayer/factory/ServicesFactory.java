package POS_final.domainLayer.factory;

import POS_final.domainLayer.tax.GoodAsGoldTaxProAdapter;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;
import POS_final.domainLayer.tax.TaxMasterAdapter;

//객체 생성 전문 클래스
public class ServicesFactory {
//미리 자신의 객체를 만들어 놓음 (적극적 초기화) - 미리 만들어 놓았다
	static ServicesFactory instance = new ServicesFactory();
	//생성자를 private로 해줌
	private ServicesFactory(){
		
	}
	//ServicesFactory객체를 반환하는 메소드
	static public ServicesFactory getInstance(){
		return instance; 
		//static method이기 때문에 클래스에 존재하기 때문에 객체보다 먼저 존재 -> Static 메소드는 항상 static 만 접근 할 수 있다.
	}
	
	//세금계산기 어댑터를 생성해서 반환하는 메소드
	 public ITaxCalculatorAdapter getTaxCalculatorAdapter( ) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//		if( ){
//		//1) TaxMAster 세금계산기 이용 시 
//		return new TaxMasterAdapter();
//		}
//		else {
//		// 2)Gold 세금계산기 이용시
//		return new GoodAsGoldTaxProAdapter();}
		 
		//강의노트 26장 13페이지
		 //생성할 세금계산기 클래스 이름을  다른 곳에서 지정했다면 
		 //이것을 이용해서 세금계산기 어댑터를 생성하자!!
		 //다른곳에서 지정하는 방법: 시스템 속성을 이용함
		 String className = System.getProperty("taxcalculator.class.name");
		 //className을 이용하여 세금계산기 어댑터를 생성
		 ITaxCalculatorAdapter taxAdapter = (ITaxCalculatorAdapter) Class.forName(className).newInstance();
		 
		 return taxAdapter;
	}
	 
	 
}

