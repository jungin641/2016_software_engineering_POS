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
	// �����ͺ��̽� �����ϱ� ���� ����
	private Connection myConnection;
	private Statement myStatement;
	private ResultSet myResultSet;
	
	
	public ProductCatalog(String databaseDriver, String databaseURL){
		// DB������ ������
				try {
					// Class��� �̸��� Ŭ���� (Ŭ���� ã���ִ� ���� ��), databaseDriver�� �ε��ϴ� ����
					Class.forName(databaseDriver);

					// �� ��° ���ڷ� ���� databaseURL�� �༭ ����
					myConnection = DriverManager.getConnection(databaseURL);

					// SQL�� ���� �غ�
					myStatement = myConnection.createStatement();
				} catch (SQLException exception) // SQL�� ������ ĳġ�Ͽ� ���
				{
					exception.printStackTrace();
				} catch (ClassNotFoundException exception) // Ŭ���� �� ã���� �� ĳġ�ؼ� ���
				{
					exception.printStackTrace();
				}		
				 loadProdSpecs();
	}
	
	public ProductDescription getProductDescription(ItemID id){
		//�˻��� �ȵż� nullpointerexception �� :  ItemID ������ int������ �ٲ��� �� toString ���� �ٲ�
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
