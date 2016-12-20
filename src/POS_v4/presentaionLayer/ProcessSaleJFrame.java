package POS_v4.presentaionLayer;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	
	private JLabel jLabel_studentId = new JLabel("학번 : 20141311");
	private JLabel jLabel_name = new JLabel(" 이름 : 유정인");
	//1. for makenewSale()
	private JButton jbutton_makeNewSale = new JButton();
	private JButton jbutton_enterItem = new JButton();
	
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
		setSize(250,300);
		setVisible(true);
	}
	
	private void initGUI() {
		GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
       
        
		
		//레이아웃매니저 지정
        setLayout(gbl);
		
		//GUI컴퓨넌트 속성 지정
		jTextFiel_itemID.setPreferredSize(new Dimension(60,20));
		jTextFiel_quantiy.setPreferredSize(new Dimension(60,20));

		jTextFiel_total.setPreferredSize(new Dimension(100,20));
		jTextFiel_cash.setPreferredSize(new Dimension(60,20));
		jTextFiel_balance.setPreferredSize(new Dimension(60,20));
		
		jbutton_makeNewSale.setLabel("1. makeNewSale");
		jbutton_enterItem.setLabel("2. enterItem");
		
		//GUI컴퓨넌트 추가
		gbAdd(gbl, gbc, jLabel_studentId, 0, 0, 1, 1);
		gbAdd(gbl, gbc, jLabel_name, 0, 1, 1, 1);
		gbAdd(gbl, gbc, jbutton_makeNewSale, 1, 0, 2, 1);
		gbAdd(gbl, gbc, jLabel_itemId, 2, 0, 1, 1);
		gbAdd(gbl, gbc, jTextFiel_itemID, 2, 1, 1, 1);
		gbAdd(gbl, gbc, jLabel_quantiy, 3, 0, 1, 1);
		gbAdd(gbl, gbc, jTextFiel_quantiy, 3, 1, 1, 1);
		gbAdd(gbl, gbc, jbutton_enterItem, 4, 0, 2, 1);
		gbAdd(gbl, gbc, jbutton_endSale, 5, 0, 2, 1);
		gbAdd(gbl, gbc, jLabel_total, 6, 0, 1, 1);
		gbAdd(gbl, gbc, jTextFiel_total, 6, 1, 1, 1);
		gbAdd(gbl, gbc, jLabel_cash, 7, 0, 1, 1); 
		gbAdd(gbl, gbc, jTextFiel_cash, 7, 1, 1, 1); 
		gbAdd(gbl, gbc, jbutton_makePayment, 8, 0, 2, 1); 
		gbAdd(gbl, gbc, jLabel_balance, 9, 0, 1, 1); 
		gbAdd(gbl, gbc, jTextFiel_balance, 9, 1, 1, 1); 
		 
		
		
		//리스너 등록
		jbutton_makeNewSale.addActionListener(this);
		jbutton_enterItem.addActionListener(this);
		jbutton_endSale.addActionListener(this);
		jbutton_makePayment.addActionListener(this);
	}
	
	 private void gbAdd(GridBagLayout gbl, GridBagConstraints gbc, Component c, int x, int y, int w, int h) {

	      gbc.gridy = x;
	      gbc.gridx = y; 
	      //가장 왼쪽 위 gridx, gridy값은 0 
	      gbc.gridwidth  = w;	//넓이
	      gbc.gridheight = h;	//높이
	      //gridwidth를 GridBagConstraints.REMAINDER 값으로 설정하면 현재 행의 마지막 셀이되고, 
	      //gridheight를 GridBagConstraints.REMAINDER 값으로 설정하면 현재 열의 마지막 셀이됩니다. 
	      //gridwidth를 GridBagConstraints. RELATIVE 값으로 설정하면 현재 행의 다음 셀부터 마지막 셀까지 차지하고, 
	      //gridheight를 GridBagConstraints. RELATIVE 값으로 설정하면 현재 열의 다음 셀부터 마지막 셀까지 차지하도록 합니다.
	      
	      gbl.setConstraints(c, gbc); //컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치
	 
	      add(c);

	   }
	@Override
	public void actionPerformed (ActionEvent event){
		
			if(event.getSource() == jbutton_makeNewSale ){
				System.out.println("makenewSale 버튼이 눌러�볼慧求�");
			//컨트롤러에게 메시지 전달
				sale = register.makeNewSale();
			}	
			else if(event.getSource() == jbutton_enterItem){

				System.out.println("enterItem 버튼이 눌러�볼慧求�");;
				register.enterItem(
						new ItemID(Integer.parseInt(jTextFiel_itemID.getText())) 
								, Integer.parseInt(jTextFiel_quantiy.getText())
						);
				jTextFiel_itemID.setText("");
				jTextFiel_quantiy.setText("");
				
				jTextFiel_total.setText("" + sale.getTotal());
			}
			else if(event.getSource() == jbutton_endSale){
				System.out.println("endSale 버튼이 눌러�볼慧求�");;
				//컨트롤러에게 메시지 전달
				register.endSale();
				
			}
			else if(event.getSource() == jbutton_makePayment){
				System.out.println("makePayment 버튼이 눌러�볼慧求�");;
				//고객이 낸 돈 얻기 + 컨트롤러에게 전달
				register.makePayment(new Money(Integer.parseInt(jTextFiel_cash.getText())));
				
				//잔액 표시하기
				jTextFiel_balance.setText(sale.getBalance().toString());

	
			}
			
		}
}