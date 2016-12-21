package POS_final.domainLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;

public class ProductCatalog {
//	private Map<ItemID, ProductDescription> descriptions = new HashMap<ItemID,ProductDescription>();
	private Map<String, ProductDescription> descriptions = new HashMap<String,ProductDescription>();
	// 데이터베이스 접근하기 위한 변수
	private Connection myConnection;
	private Statement myStatement;
	private ResultSet myResultSet;
	
	public ProductCatalog(){
		 loadProdSpecs();
	}
//	public ProductCatalog(String databaseDriver, String databaseURL){
//		// DB연결한 생성자
//				try {
//					// Class라는 이름의 클래스 (클래스 찾아주는 일을 함), databaseDriver을 로드하는 역할
//					Class.forName(databaseDriver);
//
//					// 두 번째 인자로 들어온 databaseURL을 줘서 연결
//					myConnection = DriverManager.getConnection(databaseURL);
//
//					// SQL문 실행 준비
//					myStatement = myConnection.createStatement();
//				} catch (SQLException exception) // SQL문 오류시 캐치하여 출력
//				{
//					exception.printStackTrace();
//				} catch (ClassNotFoundException exception) // 클래스 못 찾았을 때 캐치해서 출력
//				{
//					exception.printStackTrace();
//				}		
//	}
	
	public ProductDescription getProductDescription(ItemID id){
		//검색이 안돼서 nullpointerexception 뜸 :  ItemID 형에서 int형으로 바꿔준 후 toString 으로 바꿈
		return descriptions.get(id.toString()); // key
	}
	
	public void loadIds(JComboBox idJComboBox){
		// 계좌번호 가져온 결과가 myResultSet이라는 Result타입에 들어감
		try {
			myResultSet = myStatement.executeQuery("SELECT itemId FROM ProductDescriptions ");
			// 계좌번호들을 J콤보박스에 추가
			System.out.println("load IDs completed");
			while (myResultSet.next())// 커서의 위치를 다음으로 옮긴 후, 데이터가 더 있으면 true를 리턴함
			{
				idJComboBox.addItem(myResultSet.getString("itemId")); 

			}
			myResultSet.close();// 데이터베이스 쓸 때는 마무리도 잘 해주어야 한다!

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void loadProdSpecs(){
		
		//견본 데이터
				ItemID id1= new ItemID(100); // 새우깡
				Money price1 = new Money(1000);
				
				ItemID id2= new ItemID(200); // 빼빼로
				Money price2 = new Money(2000);
				
				ItemID id3= new ItemID(300); // 
				Money price3 = new Money(3000);
				
				ItemID id4= new ItemID(400); // 
				Money price4 = new Money(4000);
				
				ItemID id5= new ItemID(500); //
				Money price5 = new Money(5000);
				
		//견본데이터 등록
				ProductDescription desc;
				
				desc = new ProductDescription(id1, price1, "SaeWooKang");
				descriptions.put(id1.toString(), desc); //key value
				
				desc = new ProductDescription(id2, price2, "SinRaMyeon");
				descriptions.put(id2.toString(), desc);
				
				desc = new ProductDescription(id3, price3, "Cola");
				descriptions.put(id3.toString(), desc); //key value
				
				desc = new ProductDescription(id4, price4, "Hamburger");
				descriptions.put(id4.toString(), desc);

				desc = new ProductDescription(id5, price5, "Chocolate");
				descriptions.put(id5.toString(), desc);
			
	}
}
