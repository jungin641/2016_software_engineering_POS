package POS_v2.presentaionLayer;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

import POS_v2.domainLayer.Register;

public class ProcessSaleJFrame extends JFrame {
	
	//컨트롤러
	private Register register;
	
	//GUI컴퓨넌트 선언
	private JButton jbutton_makeNewSale = new JButton();
	private Container contentPane = getContentPane();
	
	//생성자
	public ProcessSaleJFrame(Register register){
		this.register = register;
		initGUI();
	}

	private void initGUI() {
		contentPane
	}
}
