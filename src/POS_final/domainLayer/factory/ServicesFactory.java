package POS_final.domainLayer.factory;

import POS_final.domainLayer.tax.GoodAsGoldTaxProAdapter;
import POS_final.domainLayer.tax.ITaxCalculatorAdapter;
import POS_final.domainLayer.tax.TaxMasterAdapter;

//객체 생성 전문 클래스
public class ServicesFactory {
	private  ITaxCalculatorAdapter taxAdapter;
//미리 자신의 객체를 만들어 놓지 않음 (소극적 초기화)
	static ServicesFactory instance;
	//생성자를 private로 해줌
	private ServicesFactory(){
		
	}
	//ServicesFactory객체를 반환하는 메소드
	//이 메소드가 호출되면 이 때 자신의 객체를 만든다.
	//여러 스레드가 동시에 이 메소드를 호출하는 경우, 
	// 한 스레드만 이 메소드 안으로 들어오게 해야 한다. -> Syncronized로 해결
	public static synchronized ServicesFactory getInstance(){
		if(instance == null){ //이 메소드가 처음 호출되었으면...
			//ServicesFactory 생성 전에 무언가 할 수 있다~
			instance = new ServicesFactory();
			return instance;
		}
		else
			return instance; 
		//static method이기 때문에 클래스에 존재하기 때문에 객체보다 먼저 존재 -> Static 메소드는 항상 static 만 접근 할 수 있다.
	}
	
	//세금계산기 어댑터를 생성해서 반환하는 메소드
	//세금계산기 어댑터를 생성해서 반환하는 메소드
		 public ITaxCalculatorAdapter getTaxCalculatorAdapter( ) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
			//강의노트 26장 13페이지
			 //생성할 세금계산기 클래스 이름을  다른 곳에서 지정했다면 
			 //이것을 이용해서 세금계산기 어댑터를 생성하자!!
			 //다른곳에서 지정하는 방법: 시스템 속성을 이용함
			 String className = System.getProperty("taxcalculator.class.name");
			 //className을 이용하여 세금계산기 어댑터를 생성
			 taxAdapter = (ITaxCalculatorAdapter) Class.forName(className).newInstance();
		
			 return taxAdapter;
		}
		
	
}

