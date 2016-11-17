package POS_v2.presentaionLayer;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import POS_v2.domainLayer.Register;

public class ProcessSaleJFrame extends JFrame implements ActionListener{
	
	//컨트롤러
	private Register register;
	
	//GUI컴퓨넌트 선언
	private JButton jbutton_makeNewSale = new JButton();
	private Container contentPane = getContentPane();
	
	//생성자
	public ProcessSaleJFrame(Register register){
		this.register = register;
		initGUI();
		pack(); //GUI 컴포넌트 정리
		setVisible(true);
	}

	private void initGUI() {
		//레이아웃매니저 지정
		contentPane.setLayout(new FlowLayout());
		
		
		jbutton_makeNewSale.setLabel("1. makeNewSale");
		//button 추가
		contentPane.add(jbutton_makeNewSale);
		
		//리스너 등록
		jbutton_makeNewSale.addActionListener(this);
	}
	@Override
	public void actionPerformed (ActionEvent event){
		
			if(event.getSource() == jbutton_makeNewSale ){
				System.out.println("makenewSale 버튼이 눌러졋숨니다");
			//컨트롤러에게 메시지 전달
				register.makeNewSale();
			}	
		}
}
