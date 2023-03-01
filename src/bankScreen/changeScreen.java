package bankScreen;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import bankView.*;

public class changeScreen {
	private JPanel root;
	private String nowPanel;
	private loginPanel loginPanel;
	private optionPanel optionPanel;
	private infoPanel infoPanel;
	private chooseValuePanel chooseValuePanel;
	private transferPanel transferPanel;
	private accBalancePanel accBalancePanel;
	private changePinPanel changePinPanel;
	private completePanel completePanel;
	private enoughMoneyPanel enoughMoneyPanel;
	private enterValueMoney enterValue;
	
	public changeScreen(JPanel root) {
		this.root = root;
	}
	
	public loginPanel getLoginPanel() {
		return loginPanel;
	}
	
	public transferPanel getTransferPanel() {
		return transferPanel;
	}
	
	public enterValueMoney getEnterValue() {
		return enterValue;
	}
	
	public changePinPanel getChangePin() {
		return changePinPanel;
	}

	public String getNowPanel() {
		return nowPanel;
	}

	public void setNowPanel(String nowPanel) {
		this.nowPanel = nowPanel;
	}
	
	public void setMainView() {
		this.setNowPanel("DangNhap");
		
		loginPanel = new loginPanel();
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(loginPanel);
		root.revalidate();
		root.repaint();
	}
	
	public void setOptionView() {
		this.setNowPanel("TuyChon");
		
		optionPanel = new optionPanel();
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(optionPanel);
		root.revalidate();
		root.repaint();
	}
	
	public void setInfoView(String accClicked) {
		this.setNowPanel("ThongTinTK");
		
		infoPanel = new infoPanel(accClicked);
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(infoPanel);
		root.revalidate();
		root.repaint();
	}
	
	public void setChooseValueView() {
		this.setNowPanel("ChonMenhGia");
		
		chooseValuePanel = new chooseValuePanel();
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(chooseValuePanel);
		root.revalidate();
		root.repaint();
	}
	
	public void setTransferView(String nowAcc) {
		this.setNowPanel("ChuyenTien");
		
		transferPanel = new transferPanel(nowAcc);
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(transferPanel);
		root.revalidate();
		root.repaint();
	}
	
	public void setChangePinView(String accClicked, String name, String lbl1, String lbl2) {
		this.setNowPanel(name);
		
		changePinPanel = new changePinPanel(accClicked, lbl1, lbl2);
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(changePinPanel);
		root.revalidate();
		root.repaint();
	}
	
	public void setAccBalanceView(String accClicked) {
		this.setNowPanel("XemSoDu");
		
		accBalancePanel = new accBalancePanel(accClicked);
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(accBalancePanel);
		root.revalidate();
		root.repaint();
	}
	
	public void setCompleteView() {
		this.setNowPanel("HoanThanh");
		
		completePanel = new completePanel();
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(completePanel);
		root.revalidate();
		root.repaint();
	}
	
	public void setEnoughMoneyView() {
		this.setNowPanel("KhongDuTien");
		
		enoughMoneyPanel = new enoughMoneyPanel();
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(enoughMoneyPanel);
		root.revalidate();
		root.repaint();
	}
	
	public void setEnterValue(String accClicked) {
		this.setNowPanel("NhapTien");
		
		enterValue = new enterValueMoney(accClicked);
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(enterValue);
		root.revalidate();
		root.repaint();
	}
}
