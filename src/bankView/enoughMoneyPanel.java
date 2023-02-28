package bankView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class enoughMoneyPanel extends JPanel {

	public enoughMoneyPanel() {
		this.initComponents();
	}
	
	public void initComponents() {
		this.setBounds(67, 11, 450, 371);
		this.setBackground(new Color(102, 179, 255));
		this.setForeground(new Color(0, 0, 0));
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SỐ TIỀN TRONG TÀI KHOẢN CỦA BẠN KHÔNG ĐỦ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 62, 405, 32);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel(" ĐỂ THỰC HIỆN GIAO DỊCH NÀY");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(82, 81, 286, 32);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("BẠN CÓ MUỐN THỰC HIỆN GIAO DỊCH KHÁC KHÔNG ?");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 124, 416, 32);
		add(lblNewLabel_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(0, 0, 153));
		panel_1_1_1.setBounds(278, 207, 162, 50);
		add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblThongTin = new JLabel("CÓ");
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
		
		JLabel lblThoat = new JLabel("KHÔNG");
		lblThoat.setHorizontalAlignment(SwingConstants.TRAILING);
		lblThoat.setForeground(Color.WHITE);
		lblThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThoat.setBounds(10, 11, 142, 28);
		panel_1_2_1.add(lblThoat);
	}

}
