package bankView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import bankController.transferController;
import bankDatabase.loginDatabase;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import javax.swing.JTextField;

public class transferPanel extends JPanel {
	private transferController transfer;
	private DefaultListModel<String> user;
	private JList<String> list;
	private JLabel lblNameAcc;
	public void setLblNameAcc(String string) {
		this.lblNameAcc.setText(string);
	}

	private String accClicked;
	public String getAccClicked() {
		return accClicked;
	}

	private String nowAcc;
	private JTextField valueTrans;
	private JLabel lblNote;
	private JTextField textField;
	private JLabel lblChooseAcc;

	public JTextField getValueTrans() {
		return valueTrans;
	}

	public void setValueTrans(String value) {
		this.valueTrans.setText(value);;
	}

	public String getNowAcc() {
		return nowAcc;
	}

	public void setNowAcc(String nowAcc) {
		this.nowAcc = nowAcc;
	}

	public transferController getTransfer() {
		return transfer;
	}

	public transferPanel(String nowAcc) {
		this.setNowAcc(nowAcc);
		this.initComponents();
		transfer = new transferController(this);
	}
	
	public void initComponents() {
		this.setBounds(67, 11, 450, 371);
		this.setBackground(new Color(102, 179, 255));
		this.setForeground(new Color(0, 0, 0));
		this.setLayout(null);
		
		lblNameAcc = new JLabel("");
		lblNameAcc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameAcc.setBounds(193, 197, 137, 20);
		add(lblNameAcc);
		
		lblChooseAcc = new JLabel("HÃY CHỌN TÀI KHOẢN ĐỂ THỰC HIỆN!");
		lblChooseAcc.setForeground(Color.RED);
		lblChooseAcc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChooseAcc.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAcc.setBounds(77, 312, 296, 20);
		add(lblChooseAcc);
		lblChooseAcc.setVisible(false);
		
		user = new DefaultListModel<>();
		this.getUser(user);
		list = new JList<String>(user);
		list.setBounds(80, 296, 196, 64);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//list.setSelectedIndex(0);
		//list.setSelectedValue(user, true);
		//accClicked = list.getSelectedValue();
		//System.out.println(accClicked.toString());
		list.setVisibleRowCount(4);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				accClicked = (String) list.getSelectedValue();
				transfer.labelName(accClicked);
				transfer.clearChooseAcc();
				transfer.clearValueTransfer();
			}
		});
		
		JScrollPane listScroll = new JScrollPane(list);
		listScroll.setBounds(133, 150, 198, 29);
		JPanel p = new JPanel(new BorderLayout());
		p.setBackground(new Color(5, 5, 5));
		p.setForeground(new Color(0, 0, 0));
		p.setBounds(132, 117, 198, 75);
		p.add(listScroll, BorderLayout.CENTER);
		//p.add(list, BorderLayout.SOUTH);
		this.add(p);
		
		textField = new JTextField();
		textField.setBounds(132, 97, 198, 20);
		add(textField);
		textField.setColumns(10);
		textField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				filter();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				filter();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			private void filter() {
				String filter = textField.getText();
				filterModel((DefaultListModel<String>)list.getModel(), filter);
			}
		});
		
		JLabel lblNewLabel = new JLabel("CHỌN TÀI KHOẢN MUỐN CHUYỂN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(77, 58, 296, 37);
		add(lblNewLabel);
		
		valueTrans = new JTextField();
		valueTrans.setHorizontalAlignment(SwingConstants.CENTER);
		valueTrans.setFont(new Font("Tahoma", Font.BOLD, 14));
		valueTrans.setBounds(141, 258, 168, 29);
		add(valueTrans);
		valueTrans.setColumns(10);
		valueTrans.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("NHẬP SỐ TIỀN KHÔNG QUÁ 8 CHỮ SỐ\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(104, 233, 241, 14);
		add(lblNewLabel_1);
		
		lblNote = new JLabel("");
		lblNote.setForeground(Color.RED);
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setBounds(32, 287, 384, 29);
		add(lblNote);
	}
	
	public void getUser(DefaultListModel<String> user) {
		String sqlSelect = "SELECT * FROM CardInfo";
		try {
			Connection con = loginDatabase.getConnection();
			Statement st = con.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sqlSelect);
			
			
			while(rs.next()) {
				if(this.getNowAcc().equals(rs.getString("AccNum"))==false) {
					user.addElement(rs.getString("AccNum"));
				}
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void filterModel(DefaultListModel<String> model, String filter) {
		String sqlSelect = "SELECT * FROM CardInfo";
		try {
			Connection con = loginDatabase.getConnection();
			Statement st = con.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sqlSelect);
			
			
			while(rs.next()) {
				String s = rs.getString("AccNum");
				
				if(this.getNowAcc().equals(s)==false) {
					if(!s.startsWith(filter)) {
						if(model.contains(s)) {
							model.removeElement(s);
						}
					}
					else {
						if(!model.contains(s)) {
							model.addElement(s);
						}
					}
				}
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clearNote() {
		lblNote.setText("");
	}
	
	public void setNote() {
		lblNote.setText("SỐ TIỀN PHẢI LÀ BỘI CỦA 10.000 VÀ KHÔNG VƯỢT QUÁ 20.000.000");
	}
	
	public void setChooseAcc() {
		lblChooseAcc.setVisible(true);
	}
	
	public void clearChooseAcc() {
		lblChooseAcc.setVisible(false);
	}
	
	public void enterValueNote() {
		lblNote.setText("HÃY NHẬP SỐ TIỀN BẠN MUỐN CHUYỂN!");
	}
}
