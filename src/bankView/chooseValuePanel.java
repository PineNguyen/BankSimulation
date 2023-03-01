package bankView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class chooseValuePanel extends JPanel {
	
	public chooseValuePanel() {
		this.initComponents();
	}
	
	public void initComponents() {
		this.setBounds(67, 11, 450, 371);
		this.setBackground(new Color(102, 179, 255));
		this.setForeground(new Color(0, 0, 0));
		this.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 153));
		panel_1.setBounds(10, 129, 145, 50);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_1 = new JLabel("2.000.000");
		lbl_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lbl_1.setForeground(new Color(255, 255, 255));
		lbl_1.setBounds(10, 11, 142, 28);
		panel_1.add(lbl_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 0, 153));
		panel_1_1.setBounds(10, 207, 145, 50);
		add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lbl_2 = new JLabel("1.500.000");
		lbl_2.setForeground(Color.WHITE);
		lbl_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_2.setBounds(10, 11, 142, 28);
		panel_1_1.add(lbl_2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 0, 153));
		panel_1_2.setBounds(10, 286, 145, 50);
		add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lbl_3 = new JLabel("1.000.000");
		lbl_3.setForeground(Color.WHITE);
		lbl_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_3.setBounds(10, 11, 142, 28);
		panel_1_2.add(lbl_3);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(0, 0, 153));
		panel_1_3.setBounds(295, 129, 145, 50);
		add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JLabel lbl_4 = new JLabel("500.000");
		lbl_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_4.setForeground(Color.WHITE);
		lbl_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_4.setBounds(0, 11, 142, 28);
		panel_1_3.add(lbl_4);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(0, 0, 153));
		panel_1_1_1.setBounds(295, 207, 145, 50);
		add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lbl_5 = new JLabel("200.000");
		lbl_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_5.setForeground(Color.WHITE);
		lbl_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_5.setBounds(0, 11, 142, 28);
		panel_1_1_1.add(lbl_5);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(new Color(0, 0, 153));
		panel_1_2_1.setBounds(295, 286, 145, 50);
		add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		
		JLabel lb_SoKhac = new JLabel("SỐ KHÁC");
		lb_SoKhac.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_SoKhac.setForeground(Color.WHITE);
		lb_SoKhac.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_SoKhac.setBounds(0, 11, 142, 28);
		panel_1_2_1.add(lb_SoKhac);
		
		JLabel lblNewLabel = new JLabel("HÃY CHỌN MỆNH GIÁ MÀ BẠN MUỐN THỰC HIỆN");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(44, 58, 361, 42);
		add(lblNewLabel);
	}

}
