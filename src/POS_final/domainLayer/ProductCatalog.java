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
	
	public ProductCatalog(){
		 loadProdSpecs();
	}
//	public ProductCatalog(String databaseDriver, String databaseURL){
//		// DB������ ������
//				try {
//					// Class��� �̸��� Ŭ���� (Ŭ���� ã���ִ� ���� ��), databaseDriver�� �ε��ϴ� ����
//					Class.forName(databaseDriver);
//
//					// �� ��° ���ڷ� ���� databaseURL�� �༭ ����
//					myConnection = DriverManager.getConnection(databaseURL);
//
//					// SQL�� ���� �غ�
//					myStatement = myConnection.createStatement();
//				} catch (SQLException exception) // SQL�� ������ ĳġ�Ͽ� ���
//				{
//					exception.printStackTrace();
//				} catch (ClassNotFoundException exception) // Ŭ���� �� ã���� �� ĳġ�ؼ� ���
//				{
//					exception.printStackTrace();
//				}		
//	}
	
	public ProductDescription getProductDescription(ItemID id){
		//�˻��� �ȵż� nullpointerexception �� :  ItemID ������ int������ �ٲ��� �� toString ���� �ٲ�
		return descriptions.get(id.toString()); // key
	}
	
	public void loadIds(JComboBox idJComboBox){
		// ���¹�ȣ ������ ����� myResultSet�̶�� ResultŸ�Կ� ��
		try {
			myResultSet = myStatement.executeQuery("SELECT itemId FROM ProductDescriptions ");
			// ���¹�ȣ���� J�޺��ڽ��� �߰�
			System.out.println("load IDs completed");
			while (myResultSet.next())// Ŀ���� ��ġ�� �������� �ű� ��, �����Ͱ� �� ������ true�� ������
			{
				idJComboBox.addItem(myResultSet.getString("itemId")); 

			}
			myResultSet.close();// �����ͺ��̽� �� ���� �������� �� ���־�� �Ѵ�!

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void loadProdSpecs(){
		
		//�ߺ� ������
				ItemID id1= new ItemID(100); // �����
				Money price1 = new Money(1000);
				
				ItemID id2= new ItemID(200); // ������
				Money price2 = new Money(2000);
				
				ItemID id3= new ItemID(300); // 
				Money price3 = new Money(3000);
				
				ItemID id4= new ItemID(400); // 
				Money price4 = new Money(4000);
				
				ItemID id5= new ItemID(500); //
				Money price5 = new Money(5000);
				
		//�ߺ������� ���
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
