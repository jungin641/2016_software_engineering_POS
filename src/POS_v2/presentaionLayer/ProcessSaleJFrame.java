package POS_v2.presentaionLayer;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

import POS_v2.domainLayer.Register;

public class ProcessSaleJFrame extends JFrame {
	
	//��Ʈ�ѷ�
	private Register register;
	
	//GUI��ǻ��Ʈ ����
	private JButton jbutton_makeNewSale = new JButton();
	private Container contentPane = getContentPane();
	
	//������
	public ProcessSaleJFrame(Register register){
		this.register = register;
		initGUI();
	}

	private void initGUI() {
		contentPane
	}
}
