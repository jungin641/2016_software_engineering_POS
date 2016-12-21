package POS_final.presentaionLayer;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import POS_final.domainLayer.*;


public class ProcessSaleJFrame extends JFrame implements ActionListener{
	private static final Insets insets = new Insets(0, 0, 0, 0);
	//컨트롤러
	private Register register;
	
	//현재 판매 객체
	private Sale sale;
	//GUI컴퓨넌트 선언
	
	
	//1. for makenewSale()
	private JButton jbutton_makeNewSale = new JButton("1. makeNewSale");
	private JLabel jLabel_itemId = new JLabel("item id: ");
	
// JCombobox쓰는 법
//	//Create the combo box, select item at index 4.
//	//Indices start at 0, so 4 specifies the pig.
//	JComboBox petList = new JComboBox(idStrings);
//	petList.setSelectedIndex(4);
//	petList.addActionListener(this);
	String[] idStrings = { "100", "200", "300", "400", "500" };
	private JComboBox jComboBox_itemID = new JComboBox(idStrings);
	private JLabel jLabel_quantiy = new JLabel("quantity: ");
	private JTextField jTextFiel_quantiy = new JTextField();
	private JLabel jLabel_description = new JLabel("description: ");
	private JTextField jTextFiel_description = new JTextField();
	
	//2. for enterItem()
	private JButton jbutton_enterItem = new JButton("2. enterItem() (반복)");
	private JLabel jLabel_currentTotal = new JLabel("Current Total: "); //세금 계산한 총
	private JTextField jTextFiel_currentTotal = new JTextField();

	
	//3. for endSale()
	private JButton jbutton_endSale = new JButton("3. endSale()");
	private ButtonGroup buttonGroup_tax = new ButtonGroup();
	private JRadioButton jradioButton_taxMaster = new JRadioButton("TaxMaster", false);
	private JRadioButton jradioButton_goodAsGoldTaxPro = new JRadioButton("GoodAsGoldTaxPro", false);

	//4. for calculateTax()
	private JButton jbutton_calcuateTax = new JButton("4. calcuateTax()");
	private JLabel jLabel_total_with_tax = new JLabel("Total with Tax: "); //세금 계산한 총
	private JTextField jTextFiel_total_with_tax = new JTextField();
	private JRadioButton jradioButton_bestForCustomer = new JRadioButton("BestForCustomer", false);
	private JRadioButton jradioButton_bestForStore = new JRadioButton("BestForStore", false);
	private ButtonGroup buttonGroup_discount = new ButtonGroup();
	
	
	//5. for applyDiscount()
	private JButton jbutton_applyDiscount = new JButton("5. applyDiscount()");
	private JLabel jLabel_total_after_discount = new JLabel("Total after Discount: "); //세금 계산한 총
	private JTextField jTextFiel_total_after_discount = new JTextField();
	private JLabel jLabel_amount = new JLabel("Amount: "); //세금 계산한 총
	private JTextField jTextFiel_amount = new JTextField();

	//6. for makePayment()
	private JButton jbutton_makePayment = new JButton("6. makePayment()");
	private JLabel jLabel_balance = new JLabel("balance: "); // 잔돈
	private JTextField jTextFiel_balance = new JTextField();
	
	private JTextArea jTextarea_window = new JTextArea();
	
	//생성자
	public ProcessSaleJFrame(Register register){
		this.register = register;
		initGUI();
		pack(); //GUI 컴포넌트 정리
		setSize(600,550);
		setVisible(true);
	}
	
	private void initGUI() {
		GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
       
        setTitle("POS System ( 학번 : 20141311 이름 : 유정인 ) ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		//레이아웃매니저 지정
        setLayout(gbl);
		
		//GUI컴넌트 속성 지정
        jComboBox_itemID.setPreferredSize(new Dimension(60,20));
		jTextFiel_quantiy.setPreferredSize(new Dimension(60,20));
		jTextFiel_description.setPreferredSize(new Dimension(60,20));
		jTextFiel_description.setEditable(false);
		jTextFiel_currentTotal.setPreferredSize(new Dimension(60,20));
		jTextFiel_currentTotal.setEditable(false);
		jTextFiel_total_with_tax.setPreferredSize(new Dimension(60,20));
		jTextFiel_total_with_tax.setEditable(false);
		jTextFiel_total_after_discount.setPreferredSize(new Dimension(60,20));
		jTextFiel_total_after_discount.setEditable(false);
		jTextFiel_amount.setPreferredSize(new Dimension(60,20));
		jTextFiel_balance.setPreferredSize(new Dimension(60,20));
		jTextFiel_balance.setEditable(false);
		jTextarea_window.setPreferredSize(new Dimension (230,400));

		//라디오버튼 그룹 지
		buttonGroup_discount.add(jradioButton_bestForCustomer);
		buttonGroup_discount.add(jradioButton_bestForStore);
		buttonGroup_tax.add(jradioButton_goodAsGoldTaxPro);
		buttonGroup_tax.add(jradioButton_taxMaster);
		
		//JTextArea 속성 지정

		jTextarea_window.setText("Please click makeNewSale.\n");
		jTextarea_window.setBorder(BorderFactory.createLoweredBevelBorder()); 
		jTextarea_window.setEditable(false); // 편집불가능하게 함

		
		//GUI컴퓨넌트 추가
	
		gbAdd(gbl, gbc, jbutton_makeNewSale, 1, 0, 2, 1);
		gbAdd(gbl, gbc, jLabel_itemId, 2, 0, 1, 1);
		gbAdd(gbl, gbc, jComboBox_itemID, 2, 1, 1, 1);
		gbAdd(gbl, gbc, jLabel_quantiy, 3, 0, 1, 1);
		gbAdd(gbl, gbc, jTextFiel_quantiy, 3, 1, 1, 1);
		gbAdd(gbl, gbc, jLabel_description, 4, 0, 1, 1);
		gbAdd(gbl, gbc, jTextFiel_description, 4, 1, 1, 1);
		
		gbAdd(gbl, gbc, jbutton_enterItem, 5, 0, 2, 1);
		gbAdd(gbl, gbc, jLabel_currentTotal, 6, 0, 1, 1);
		gbAdd(gbl, gbc, jTextFiel_currentTotal, 6, 1, 1, 1);
		gbAdd(gbl, gbc, jbutton_endSale, 7, 0, 2, 1);
		gbAdd(gbl, gbc, jradioButton_taxMaster, 8, 0, 1, 1);
		gbAdd(gbl, gbc, jradioButton_goodAsGoldTaxPro, 8, 1, 1, 1);
		
		gbAdd(gbl, gbc, jbutton_calcuateTax, 9, 0, 2, 1);
		gbAdd(gbl, gbc, jLabel_total_with_tax, 10, 0, 1, 1);
		gbAdd(gbl, gbc, jTextFiel_total_with_tax, 10, 1, 1, 1);
		gbAdd(gbl, gbc, jradioButton_bestForCustomer, 11, 0, 1, 1);
		gbAdd(gbl, gbc, jradioButton_bestForStore, 11, 1, 1, 1);
		
		gbAdd(gbl, gbc, jbutton_applyDiscount, 12, 0, 2, 1);
		gbAdd(gbl, gbc, jLabel_total_after_discount, 13, 0, 1, 1);
		gbAdd(gbl, gbc, jTextFiel_total_after_discount, 13, 1, 1, 1);
		gbAdd(gbl, gbc, jLabel_amount, 14, 0, 1, 1);
		gbAdd(gbl, gbc, jTextFiel_amount, 14, 1, 1, 1);
	
		gbAdd(gbl, gbc, jbutton_makePayment, 15, 0, 2, 1); 
		gbAdd(gbl, gbc, jLabel_balance, 16, 0, 1, 1); 
		gbAdd(gbl, gbc, jTextFiel_balance, 16, 1, 1, 1); 
		
		gbAdd(gbl, gbc, jTextarea_window, 1, 2, 3, 16); 
		
	
		 
		
		
		//리스너 등록
		jbutton_makeNewSale.addActionListener(this);
		jbutton_enterItem.addActionListener(this);
		jbutton_endSale.addActionListener(this);
		jbutton_calcuateTax.addActionListener(this);
		jbutton_applyDiscount.addActionListener(this);
		jbutton_makePayment.addActionListener(this);
	}
	

	@Override
	public void actionPerformed (ActionEvent event){
		
			if(event.getSource() == jbutton_makeNewSale ){
				jTextarea_window.append("The new Sale is started\n");
			//컨트롤러에게 메시지 전달
				sale = register.makeNewSale();
			}	
			else if(event.getSource() == jbutton_enterItem){

				jTextarea_window.append("A Item is entered.\n");
				String str_quantity = jTextFiel_quantiy.getText();
				if(str_quantity.length() != 0){
					try{
						Integer.parseInt(str_quantity);
					}
					catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(this, "[Warning]Please insert digits only.");
						jTextFiel_quantiy.setText("");
					}
				}
				
				register.enterItem(
						new ItemID(Integer.parseInt(jComboBox_itemID.getSelectedItem().toString())) 
								, Integer.parseInt(jTextFiel_quantiy.getText())
						);
				
				jTextFiel_quantiy.setText("");
				
				//jTextFiel_total.setText("" + sale.getTotal());
			}
			else if(event.getSource() == jbutton_endSale){
				jTextarea_window.append("The sale is ended.\n");
				//컨트롤러에게 메시지 전달
				register.endSale();
				
			}
			else if(event.getSource() == jbutton_calcuateTax){
				jTextarea_window.append("Tax is calculated.\n");
				//컨트롤러에게 메시지 전달
			
				
			}
			else if(event.getSource() == jbutton_applyDiscount){
				jTextarea_window.append("Discount percent is applied.\n");
				//컨트롤러에게 메시지 전달
			
				
			}
			else if(event.getSource() == jbutton_makePayment){
				jTextarea_window.append("makePayment button is clicked.\n");
				//고객이 낸 돈 얻기 + 컨트롤러에게 전달
			//	register.makePayment(new Money(Integer.parseInt(jTextFiel_cash.getText())));
				
				//잔액 표시하기
				jTextFiel_balance.setText(sale.getBalance().toString());

	
			}
			
		}
	//gridBagLayout 추가하는 함수
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
}