package bankView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import bankController.changePinController;
import bankController.enterValueController;
import bankDatabase.loginDatabase;

public class changePinPanel extends JPanel {
	private changePinController changePin;
	private JPasswordField passwordField;
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(String string) {
		this.passwordField.setText(string);
	}

	private JLabel lblNote;
	private String accClicked;
	
	public String getAccClicked() {
		return accClicked;
	}

	public void setAccClicked(String accClicked) {
		this.accClicked = accClicked;
	}

	public changePinController getChange() {
		return changePin;
	}

	public changePinPanel(String accClicked, String lbl1, String lbl2) {
		this.setAccClicked(accClicked);
		this.initComponents(lbl1, lbl2);
		changePin = new changePinController(this);
	}
	
	public void initComponents(String lbl1, String lbl2) {
		this.setBounds(67, 11, 450, 371);
		this.setBackground(new Color(102, 179, 255));
		this.setForeground(new Color(0, 0, 0));
		this.setLayout(null);
		
		JLabel lblHead = new JLabel("");
		lblHead.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHead.setForeground(Color.BLUE);
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(77, 69, 296, 37);
		add(lblHead);
		lblHead.setText(lbl1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 24));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setEditable(false);
		passwordField.setEchoChar('*');
		passwordField.setBounds(159, 143, 132, 29);
		this.add(passwordField);
		
		lblNote = new JLabel("");
		lblNote.setForeground(Color.RED);
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setBounds(33, 172, 384, 29);
		add(lblNote);
		lblNote.setText(lbl2);
		
		lblNote.setVisible(false);
	}
	
	public void callNote() {
		lblNote.setVisible(true);	 
	}
	
	public void clearNote() {
		lblNote.setVisible(false);
	}
	
}
