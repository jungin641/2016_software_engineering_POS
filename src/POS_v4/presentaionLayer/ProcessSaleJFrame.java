package POS_v4.presentaionLayer;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POS_v4.domainLayer.*;

public class ProcessSaleJFrame extends JFrame implements ActionListener{
	private static final Insets insets = new Insets(0, 0, 0, 0);
	//컨트롤러
	private Register register;
	
	//현재 판매 객체
	private Sale sale;
	//GUI컴퓨넌트 선언
	//1. for makenewSale()
	private JButton jbutton_makeNewSale = new JButton();
	private JButton jbutton_enterItem = new JButton();
	private Container contentPane = getContentPane();
	
	//2. for enterItem()
	private JLabel jLabel_itemId = new JLabel("item id: ");
	private JTextField jTextFiel_itemID = new JTextField();
	private JLabel jLabel_quantiy = new JLabel("quantity: ");
	private JTextField jTextFiel_quantiy = new JTextField();
	
	//3. for endSale()
	private JButton jbutton_endSale = new JButton("3. endSale()");
	private JLabel jLabel_total = new JLabel("total: ");
	private JTextField jTextFiel_total = new JTextField();
	
	//4. for makePayment()
	private JLabel jLabel_cash = new JLabel("cash: "); //고객이 낸 돈
	private JTextField jTextFiel_cash = new JTextField();
	private JLabel jLabel_balance = new JLabel("balance: "); // 잔돈
	private JTextField jTextFiel_balance = new JTextField();

	private JButton jbutton_makePayment = new JButton("4. makePayment");
	
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
		
		//GUI컴퓨넌트 속성 지정
		jTextFiel_itemID.setPreferredSize(new Dimension(60,20));
		jTextFiel_quantiy.setPreferredSize(new Dimension(60,20));

		jTextFiel_total.setPreferredSize(new Dimension(100,20));
		jTextFiel_cash.setPreferredSize(new Dimension(60,20));
		jTextFiel_balance.setPreferredSize(new Dimension(60,20));
		
		jbutton_makeNewSale.setLabel("1. makeNewSale");
		jbutton_enterItem.setLabel("2. enterItem");

		
		//GUI컴퓨넌트 추가
		contentPane.add(jbutton_makeNewSale);
		contentPane.add(jLabel_itemId);
		contentPane.add(jTextFiel_itemID);
		contentPane.add(jLabel_quantiy);
		contentPane.add(jTextFiel_quantiy);
		contentPane.add(jbutton_enterItem);
		contentPane.add(jbutton_endSale);
		contentPane.add(jLabel_total);
		contentPane.add(jTextFiel_total);
		contentPane.add(jLabel_cash);
		contentPane.add(jTextFiel_cash);
		contentPane.add(jLabel_balance);
		contentPane.add(jTextFiel_balance);
		contentPane.add(jbutton_makePayment);
		
		//리스너 등록
		jbutton_makeNewSale.addActionListener(this);
		jbutton_enterItem.addActionListener(this);
		jbutton_endSale.addActionListener(this);
		jbutton_makePayment.addActionListener(this);
	}
	@Override
	public void actionPerformed (ActionEvent event){
		
			if(event.getSource() == jbutton_makeNewSale ){
				System.out.println("makenewSale 버튼이 눌러졋숨니다");
			//컨트롤러에게 메시지 전달
				sale = register.makeNewSale();
			}	
			else if(event.getSource() == jbutton_enterItem){

				System.out.println("enterItem 버튼이 눌러졋숨니다");;
				register.enterItem(
						new ItemID(Integer.parseInt(jTextFiel_itemID.getText())) 
								, Integer.parseInt(jTextFiel_quantiy.getText())
						);
				jTextFiel_itemID.setText("");
				jTextFiel_quantiy.setText("");
				
				jTextFiel_total.setText("" + sale.getTotal());
			}
			else if(event.getSource() == jbutton_endSale){
				System.out.println("endSale 버튼이 눌러졋숨니다");;
				//컨트롤러에게 메시지 전달
				register.endSale();
				
			}
			else if(event.getSource() == jbutton_makePayment){
				System.out.println("makePayment 버튼이 눌러졋숨니다");;
				//고객이 낸 돈 얻기 + 컨트롤러에게 전달
				register.makePayment(new Money(Integer.parseInt(jTextFiel_cash.getText())));
				
				//잔액 표시하기
				jTextFiel_balance.setText(sale.getBalance().toString());

	
			}
			
		}
}