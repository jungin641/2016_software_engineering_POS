package POS_v2.presentaionLayer;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import POS_v2.domainLayer.Register;

public class ProcessSaleJFrame extends JFrame implements ActionListener{
	
	//��Ʈ�ѷ�
	private Register register;
	
	//GUI��ǻ��Ʈ ����
	private JButton jbutton_makeNewSale = new JButton();
	private Container contentPane = getContentPane();
	
	//������
	public ProcessSaleJFrame(Register register){
		this.register = register;
		initGUI();
		pack(); //GUI ������Ʈ ����
		setVisible(true);
	}

	private void initGUI() {
		//���̾ƿ��Ŵ��� ����
		contentPane.setLayout(new FlowLayout());
		
		
		jbutton_makeNewSale.setLabel("1. makeNewSale");
		//button �߰�
		contentPane.add(jbutton_makeNewSale);
		
		//������ ���
		jbutton_makeNewSale.addActionListener(this);
	}
	@Override
	public void actionPerformed (ActionEvent event){
		
			if(event.getSource() == jbutton_makeNewSale ){
				System.out.println("makenewSale ��ư�� ���������ϴ�");
			//��Ʈ�ѷ����� �޽��� ����
				register.makeNewSale();
			}	
		}
}
