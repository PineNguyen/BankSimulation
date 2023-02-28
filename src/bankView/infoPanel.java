package bankView;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import bankDatabase.loginDatabase;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class infoPanel extends JPanel {
	private String accClicked;

	public String getAccClicked() {
		return accClicked;
	}

	public void setAccClicked(String accClicked) {
		this.accClicked = accClicked;
	}

	public infoPanel(String accClicked) {
		this.setAccClicked(accClicked);
		this.initComponents();
	}
	
	public void initComponents() {
		this.setBounds(67, 11, 450, 371);
		this.setBackground(new Color(102, 179, 255));
		this.setForeground(new Color(0, 0, 0));
		this.setLayout(null);
		
		JLabel lblAcc = new JLabel("");
		lblAcc.setHorizontalAlignment(SwingConstants.LEFT);
		lblAcc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAcc.setBounds(96, 36, 258, 43);
		add(lblAcc);
		
		JLabel lblName = new JLabel("");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(96, 90, 258, 43);
		add(lblName);
		
		JLabel lblDate = new JLabel("");
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(96, 144, 258, 43);
		add(lblDate);
		
		String sqlSelected = "SELECT * FROM Owners AS A"
				+ "	INNER JOIN Regist AS B ON A.ID = B.ID"
				+ "		INNER JOIN CardInfo AS C ON B.AccNum = C.AccNum"
				+ "			WHERE B.AccNum = " + this.getAccClicked();
		
		try {
			Connection con = loginDatabase.getConnection();
			Statement st = con.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sqlSelected);
			
			while(rs.next()) {
				if(rs.getString("AccNum").equals(this.getAccClicked())) {
					lblAcc.setText("\nMã Thẻ: " + rs.getString("AccNum"));
					
					lblName.setText("Tên Chủ TK: " + rs.getString("OwnerName"));
					
					lblDate.setText("\nNgày Sinh: " + rs.getString("DateOfBirth"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(0, 0, 153));
		panel_1_1_1.setBounds(278, 207, 162, 50);
		add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblThongTin = new JLabel("TRỞ LẠI");
		lblThongTin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblThongTin.setForeground(Color.WHITE);
		lblThongTin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThongTin.setBounds(10, 11, 142, 28);
		panel_1_1_1.add(lblThongTin);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(new Color(0, 0, 153));
		panel_1_2_1.setBounds(278, 286, 162, 50);
		add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		
		JLabel lblThoat = new JLabel("THOÁT");
		lblThoat.setHorizontalAlignment(SwingConstants.TRAILING);
		lblThoat.setForeground(Color.WHITE);
		lblThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThoat.setBounds(10, 11, 142, 28);
		panel_1_2_1.add(lblThoat);
	}
}
