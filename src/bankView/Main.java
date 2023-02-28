package bankView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;

import bankController.keyListener;
import bankScreen.changeScreen;

public class Main extends JFrame {

	private JPanel contentPane;
	private JPanel viewPanel;
	private changeScreen change;
	private keyListener pressed;

	public Main() {
		this.initComponents();
		this.setTitle("Bank Simulation");
		change = new changeScreen(viewPanel);
		change.setMainView();
		pressed.setChangeScreen(change);
		
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		//create action listenner for code
		pressed = new keyListener(this);
		
		//create keyboard panel that contains key buttons
		JPanel keyboardPanel = new JPanel();
		keyboardPanel.setBounds(85, 393, 414, 257);
		keyboardPanel.setBackground(new Color(204, 204, 204));
		keyboardPanel.setLayout(null);
		
		JButton zero = new JButton("0");
		zero.setBounds(85, 194, 50, 50);
		keyboardPanel.add(zero);
		zero.addActionListener(pressed);
		
		JButton one = new JButton("1");
		one.setBounds(25, 133, 50, 50);
		keyboardPanel.add(one);
		one.addActionListener(pressed);
		
		JButton two = new JButton("2");
		two.setBounds(85, 133, 50, 50);
		keyboardPanel.add(two);
		two.addActionListener(pressed);
		
		JButton three = new JButton("3");
		three.setBounds(145, 133, 50, 50);
		keyboardPanel.add(three);
		three.addActionListener(pressed);
		
		JButton four = new JButton("4");
		four.setBounds(25, 72, 50, 50);
		keyboardPanel.add(four);
		four.addActionListener(pressed);
		
		JButton five = new JButton("5");
		five.setBounds(85, 72, 50, 50);
		keyboardPanel.add(five);
		five.addActionListener(pressed);
		
		JButton six = new JButton("6");
		six.setBounds(145, 72, 50, 50);
		keyboardPanel.add(six);
		six.addActionListener(pressed);
		
		JButton seven = new JButton("7");
		seven.setBounds(25, 11, 50, 50);
		keyboardPanel.add(seven);
		seven.addActionListener(pressed);
		
		JButton eight = new JButton("8");
		eight.setBounds(85, 11, 50, 50);
		keyboardPanel.add(eight);
		eight.addActionListener(pressed);
		
		JButton nine = new JButton("9");
		nine.setBounds(145, 11, 50, 50);
		keyboardPanel.add(nine);
		nine.addActionListener(pressed);
		
		JButton clear = new JButton("CLEAR");
		clear.setBounds(227, 11, 117, 50);
		clear.addActionListener(pressed);
		keyboardPanel.add(clear);
		
		JButton cancel = new JButton("CANCEL");
		cancel.setBounds(227, 72, 117, 50);
		cancel.addActionListener(pressed);
		keyboardPanel.add(cancel);
		
		JButton enter = new JButton("ENTER");
		enter.setBounds(227, 133, 117, 50);
		enter.addActionListener(pressed);
		keyboardPanel.add(enter);
		
		JButton firstButton = new JButton("");
		firstButton.setBounds(7, 296, 50, 50);
		firstButton.setActionCommand("first");
		firstButton.addActionListener(pressed);
		contentPane.add(firstButton);
		
		JButton secondButton = new JButton("");
		secondButton.setBounds(7, 217, 50, 50);
		secondButton.setActionCommand("second");
		secondButton.addActionListener(pressed);
		contentPane.add(secondButton);
		
		JButton thirdButton = new JButton("");
		thirdButton.setBounds(7, 139, 50, 50);
		thirdButton.setActionCommand("third");
		thirdButton.addActionListener(pressed);
		contentPane.add(thirdButton);
		
		JButton fourthButton = new JButton("");
		fourthButton.setBounds(524, 139, 50, 50);
		fourthButton.setActionCommand("fourth");
		fourthButton.addActionListener(pressed);
		contentPane.add(fourthButton);
		
		JButton fifthButton = new JButton("");
		fifthButton.setBounds(524, 217, 50, 50);
		fifthButton.setActionCommand("fifth");
		fifthButton.addActionListener(pressed);
		contentPane.add(fifthButton);
		
		JButton sixthButton = new JButton("");
		sixthButton.setBounds(524, 296, 50, 50);
		sixthButton.setActionCommand("sixth");
		sixthButton.addActionListener(pressed);
		contentPane.add(sixthButton);
		
		//Create view panel that contains components
		viewPanel = new JPanel();
		viewPanel.setBounds(67, 11, 450, 371);
		viewPanel.setBackground(new Color(102, 179, 255));
		viewPanel.setForeground(new Color(0, 0, 0));
		viewPanel.setLayout(null);
		
		//add panel to contentPane
		contentPane.add(viewPanel);
		contentPane.add(keyboardPanel);
		
		//set visible and location
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
