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
	
	
	public ProductCatalog(String databaseDriver, String databaseURL){
		// DB연결한 생성자
				try {
					// Class라는 이름의 클래스 (클래스 찾아주는 일을 함), databaseDriver을 로드하는 역할
					Class.forName(databaseDriver);

					// 두 번째 인자로 들어온 databaseURL을 줘서 연결
					myConnection = DriverManager.getConnection(databaseURL);

					// SQL문 실행 준비
					myStatement = myConnection.createStatement();
				} catch (SQLException exception) // SQL문 오류시 캐치하여 출력
				{
					exception.printStackTrace();
				} catch (ClassNotFoundException exception) // 클래스 못 찾았을 때 캐치해서 출력
				{
					exception.printStackTrace();
				}		
				 loadProdSpecs();
	}
	
	public ProductDescription getProductDescription(ItemID id){
		//검색이 안돼서 nullpointerexception 뜸 :  ItemID 형에서 int형으로 바꿔준 후 toString 으로 바꿈
		return descriptions.get(id.toString()); // key
	}
	

	public void loadProdSpecs(){
		
		try {
			myResultSet = myStatement.executeQuery("SELECT itemId, description, price FROM ProductDescriptions ORDER BY itemID ASC");

			while (myResultSet.next()) {
				ProductDescription desc = new ProductDescription(
						new ItemID(Integer.parseInt(myResultSet.getString("itemID"))),
						new Money((int)myResultSet.getDouble("price")),
						myResultSet.getString("description"));
				
				descriptions.put(desc.getItemID().toString(), desc);
				
			}
			myResultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Map<String, ProductDescription> getItemsDescriptions() {
		// TODO Auto-generated method stub
		return descriptions;
	}
}
