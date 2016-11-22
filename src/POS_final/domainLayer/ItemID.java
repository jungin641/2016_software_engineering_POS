package POS_final.domainLayer;

public class ItemID {
	String id = null;
	
//	public ItemID(String id){
//		this.id = id;
//		
//	}
	public ItemID(int id){
		this.id = String.valueOf(id);
	}
	public String toString(){
		return id;
	}
}
