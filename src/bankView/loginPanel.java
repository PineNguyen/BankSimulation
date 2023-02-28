package bankView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import bankController.loginController;
import bankDatabase.loginDatabase;
import javax.swing.JLabel;

public class loginPanel extends JPanel {
	private JPasswordField passwordField;
	private JList<String> list;
	private DefaultListModel<String> user;
	private String accClicked;
	private JLabel lblErorr;
	
	public String getAccClicked() {
		return accClicked;
	}

	private loginController login;
	
	public loginPanel() {
		this.initComponents();
		login = new loginController(this);
	}
	
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(String string) {
		this.passwordField.setText(string);
	}

	public loginController getLogin() {
		return login;
	}
	
	public void initComponents() {
		this.setBounds(67, 11, 450, 371);
		this.setBackground(new Color(102, 179, 255));
		this.setForeground(new Color(0, 0, 0));
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHÀO MỪNG BẠN ĐẾN VỚI SB ATM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(55, 45, 340, 29);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HÃY CHỌN TÀI KHOẢN VÀ NHẬP MẬT KHẨU ĐỂ TIẾP TỤC");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(27, 81, 396, 14);
		add(lblNewLabel_1);
		
		user = new DefaultListModel<>();
		this.getUser(user);
		list = new JList<String>(user);
		list.setBounds(80, 296, 196, 64);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setSelectedValue(user, true);
		accClicked = list.getSelectedValue();
		System.out.println(accClicked.toString());
		list.setVisibleRowCount(4);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicked");
				accClicked = (String) list.getSelectedValue();
				System.out.println(accClicked.toString());
			}
		});
		
		JScrollPane listScroll = new JScrollPane(list);
		listScroll.setBounds(133, 150, 198, 29);
		JPanel p = new JPanel(new BorderLayout());
		p.setBackground(new Color(5, 5, 5));
		p.setForeground(new Color(0, 0, 0));
		p.setBounds(133, 133, 198, 75);
		p.add(listScroll, BorderLayout.CENTER);
		//p.add(list, BorderLayout.SOUTH);
		this.add(p);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 24));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setEditable(false);
		passwordField.setEchoChar('*');
		passwordField.setBounds(160, 259, 132, 29);
		this.add(passwordField);
		
		lblErorr = new JLabel("MẬT KHẨU SAI, VUI LÒNG NHẬP LẠI MẬT KHẨU!");
		lblErorr.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblErorr.setForeground(Color.RED);
		lblErorr.setHorizontalAlignment(SwingConstants.CENTER);
		lblErorr.setBounds(74, 299, 302, 29);
		this.add(lblErorr);
		
		lblErorr.setVisible(false);
		
		this.setVisible(true);
	}
	
	public void getUser(DefaultListModel<String> user) {
		System.out.println("get user");
		String sqlSelect = "SELECT * FROM CardInfo";
		try {
			Connection con = loginDatabase.getConnection();
			Statement st = con.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sqlSelect);
			
			
			while(rs.next()) {
				user.addElement(rs.getString("AccNum"));
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setLabelErorr() {
		lblErorr.setVisible(true);	 
	}
	
	public void clearLabelErorr() {
		lblErorr.setVisible(false);
	}
}
