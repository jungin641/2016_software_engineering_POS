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
	//而⑦듃濡ㅻ윭
	private Register register;
	
	//�쁽�옱 �뙋留� 媛앹껜
	private Sale sale;
	//GUI而댄벂�꼳�듃 �꽑�뼵
	
	private JLabel jLabel_studentId = new JLabel("학번: 20141311");
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
	private JLabel jLabel_cash = new JLabel("cash: "); //怨좉컼�씠 �궦 �룉
	private JTextField jTextFiel_cash = new JTextField();
	private JLabel jLabel_balance = new JLabel("balance: "); // �옍�룉
	private JTextField jTextFiel_balance = new JTextField();

	private JButton jbutton_makePayment = new JButton("4. makePayment");
	
	//�깮�꽦�옄
	public ProcessSaleJFrame(Register register){
		this.register = register;
		initGUI();
		pack(); //GUI 而댄룷�꼳�듃 �젙由�
		setSize(250,300);
		setVisible(true);
	}
	
	private void initGUI() {
		GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
       
        
		
		//�젅�씠�븘�썐留ㅻ땲�� 吏��젙
        setLayout(gbl);
		
		//GUI而댄벂�꼳�듃 �냽�꽦 吏��젙
		jTextFiel_itemID.setPreferredSize(new Dimension(60,20));
		jTextFiel_quantiy.setPreferredSize(new Dimension(60,20));

		jTextFiel_total.setPreferredSize(new Dimension(100,20));
		jTextFiel_cash.setPreferredSize(new Dimension(60,20));
		jTextFiel_balance.setPreferredSize(new Dimension(60,20));
		
		jbutton_makeNewSale.setLabel("1. makeNewSale");
		jbutton_enterItem.setLabel("2. enterItem");
		
		//GUI而댄벂�꼳�듃 異붽�
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
		 
		
		
		//由ъ뒪�꼫 �벑濡�
		jbutton_makeNewSale.addActionListener(this);
		jbutton_enterItem.addActionListener(this);
		jbutton_endSale.addActionListener(this);
		jbutton_makePayment.addActionListener(this);
	}
	
	 private void gbAdd(GridBagLayout gbl, GridBagConstraints gbc, Component c, int x, int y, int w, int h) {

	      gbc.gridy = x;
	      gbc.gridx = y; 
	      //媛��옣 �쇊履� �쐞 gridx, gridy媛믪� 0 
	      gbc.gridwidth  = w;	//�꼻�씠
	      gbc.gridheight = h;	//�넂�씠
	      //gridwidth瑜� GridBagConstraints.REMAINDER 媛믪쑝濡� �꽕�젙�븯硫� �쁽�옱 �뻾�쓽 留덉�留� ���씠�릺怨�, 
	      //gridheight瑜� GridBagConstraints.REMAINDER 媛믪쑝濡� �꽕�젙�븯硫� �쁽�옱 �뿴�쓽 留덉�留� ���씠�맗�땲�떎. 
	      //gridwidth瑜� GridBagConstraints. RELATIVE 媛믪쑝濡� �꽕�젙�븯硫� �쁽�옱 �뻾�쓽 �떎�쓬 ��遺��꽣 留덉�留� ��源뚯� 李⑥��븯怨�, 
	      //gridheight瑜� GridBagConstraints. RELATIVE 媛믪쑝濡� �꽕�젙�븯硫� �쁽�옱 �뿴�쓽 �떎�쓬 ��遺��꽣 留덉�留� ��源뚯� 李⑥��븯�룄濡� �빀�땲�떎.
	      
	      gbl.setConstraints(c, gbc); //而댄룷�꼳�듃瑜� 而댄룷�꼳�듃 �쐞移�+�겕湲� �젙蹂댁뿉 �뵲�씪 GridBagLayout�뿉 諛곗튂
	 
	      add(c);

	   }
	@Override
	public void actionPerformed (ActionEvent event){
		
			if(event.getSource() == jbutton_makeNewSale ){
				System.out.println("makenewSale 踰꾪듉�씠 �닃�윭占쎈낵�뀱黎귨옙");
			//而⑦듃濡ㅻ윭�뿉寃� 硫붿떆吏� �쟾�떖
				sale = register.makeNewSale();
			}	
			else if(event.getSource() == jbutton_enterItem){

				System.out.println("enterItem 踰꾪듉�씠 �닃�윭占쎈낵�뀱黎귨옙");;
				register.enterItem(
						new ItemID(Integer.parseInt(jTextFiel_itemID.getText())) 
								, Integer.parseInt(jTextFiel_quantiy.getText())
						);
				jTextFiel_itemID.setText("");
				jTextFiel_quantiy.setText("");
				
				jTextFiel_total.setText("" + sale.getTotal());
			}
			else if(event.getSource() == jbutton_endSale){
				System.out.println("endSale 踰꾪듉�씠 �닃�윭占쎈낵�뀱黎귨옙");;
				//而⑦듃濡ㅻ윭�뿉寃� 硫붿떆吏� �쟾�떖
				register.endSale();
				
			}
			else if(event.getSource() == jbutton_makePayment){
				System.out.println("makePayment 踰꾪듉�씠 �닃�윭占쎈낵�뀱黎귨옙");;
				//怨좉컼�씠 �궦 �룉 �뼸湲� + 而⑦듃濡ㅻ윭�뿉寃� �쟾�떖
				register.makePayment(new Money(Integer.parseInt(jTextFiel_cash.getText())));
				
				//�옍�븸 �몴�떆�븯湲�
				jTextFiel_balance.setText(sale.getBalance().toString());

	
			}
			
		}
}