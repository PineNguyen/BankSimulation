package bankView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bankController.enterValueController;

public class enterValueMoney extends JPanel {
	private JTextField valueMoney;
	private String accClicked;
	
	public String getAccClicked() {
		return accClicked;
	}

	public void setAccClicked(String accClicked) {
		this.accClicked = accClicked;
	}

	public JTextField getValueMoney() {
		return valueMoney;
	}

	public void setValueMoney(String money) {
		this.valueMoney.setText(money);
	}

	private JLabel lblNote;
	private enterValueController enterValueController;
	
	public enterValueController getEnter() {
		return enterValueController;
	}

	public enterValueMoney(String accClicked) {
		this.setAccClicked(accClicked);
		this.initComponents();
		enterValueController = new enterValueController(this);
	}
	
	public void initComponents() {
		this.setBounds(67, 11, 450, 371);
		this.setBackground(new Color(102, 179, 255));
		this.setForeground(new Color(0, 0, 0));
		this.setLayout(null);
		
		valueMoney = new JTextField();
		valueMoney.setHorizontalAlignment(SwingConstants.CENTER);
		valueMoney.setFont(new Font("Tahoma", Font.BOLD, 14));
		valueMoney.setBounds(141, 139, 168, 29);
		add(valueMoney);
		valueMoney.setColumns(10);
		valueMoney.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("SỐ TIỀN MUỐN RÚT KHÔNG QUÁ 8 CHỮ SỐ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(64, 94, 322, 34);
		add(lblNewLabel_1);
		
		lblNote = new JLabel("");
		lblNote.setForeground(Color.RED);
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setBounds(33, 168, 384, 29);
		add(lblNote);
	}
	
	public void clearNote() {
		lblNote.setText("");
	}
	
	public void setNote() {
		lblNote.setText("SỐ TIỀN PHẢI LÀ BỘI CỦA 10.000 VÀ KHÔNG VƯỢT QUÁ 15.000.000");
	}

	public void setEnterValue() {
		lblNote.setText("HÃY NHẬP MỆNH GIÁ MUỐN RÚT!");
	}
}
