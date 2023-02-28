package bankView;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class optionPanel extends JPanel {
	
	public optionPanel() {
		this.initComponents();
	}
	
	public void initComponents() {
		this.setBounds(67, 11, 450, 371);
		this.setBackground(new Color(102, 179, 255));
		this.setForeground(new Color(0, 0, 0));
		this.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 153));
		panel_1.setBounds(10, 129, 148, 50);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRutTien = new JLabel("RÚT TIỀN");
		lblRutTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRutTien.setForeground(new Color(255, 255, 255));
		lblRutTien.setBounds(10, 11, 142, 28);
		panel_1.add(lblRutTien);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 0, 153));
		panel_1_1.setBounds(10, 207, 148, 50);
		add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblXemSoDu = new JLabel("XEM SỐ DƯ");
		lblXemSoDu.setForeground(Color.WHITE);
		lblXemSoDu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblXemSoDu.setBounds(10, 11, 142, 28);
		panel_1_1.add(lblXemSoDu);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 0, 153));
		panel_1_2.setBounds(10, 286, 148, 50);
		add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblChuyenKhoan = new JLabel("CHUYỂN KHOẢN");
		lblChuyenKhoan.setForeground(Color.WHITE);
		lblChuyenKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChuyenKhoan.setBounds(10, 11, 142, 28);
		panel_1_2.add(lblChuyenKhoan);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(0, 0, 153));
		panel_1_3.setBounds(292, 129, 148, 50);
		add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JLabel lblDoiPin = new JLabel("ĐỔI PIN");
		lblDoiPin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDoiPin.setForeground(Color.WHITE);
		lblDoiPin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDoiPin.setBounds(0, 11, 142, 28);
		panel_1_3.add(lblDoiPin);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(0, 0, 153));
		panel_1_1_1.setBounds(292, 207, 148, 50);
		add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblThongTin = new JLabel("XEM THÔNG TIN");
		lblThongTin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblThongTin.setForeground(Color.WHITE);
		lblThongTin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThongTin.setBounds(0, 11, 142, 28);
		panel_1_1_1.add(lblThongTin);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(new Color(0, 0, 153));
		panel_1_2_1.setBounds(292, 286, 148, 50);
		add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		
		JLabel lblThoat = new JLabel("THOÁT");
		lblThoat.setHorizontalAlignment(SwingConstants.TRAILING);
		lblThoat.setForeground(Color.WHITE);
		lblThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThoat.setBounds(0, 11, 142, 28);
		panel_1_2_1.add(lblThoat);
		
		JLabel lblNewLabel = new JLabel("HÃY CHỌN GIAO DỊCH MÀ BẠN MUỐN THỰC HIỆN!");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 49, 371, 50);
		add(lblNewLabel);
	}
}
