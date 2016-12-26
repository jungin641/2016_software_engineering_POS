package POS_final;

import POS_final.domainLayer.Money;
import POS_final.domainLayer.Sale;

public interface PropertyListener {
	public void onPropertyEvent(Sale source,String name,Money value );
}
