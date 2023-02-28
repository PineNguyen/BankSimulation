package bankController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bankScreen.changeScreen;
import bankView.Main;
import bankView.enterValueMoney;

public class keyListener implements ActionListener {
	private Main main;
	private String kind;
	private String value;
	private changeScreen change;
	private loginController login;
	private chooseValueController chooseValue;
	private transferController transfer;
	private enterValueController enterValue;
	private changePinController changePin;
	private String newPin;

	public String getNewPin() {
		return newPin;
	}

	public void setNewPin(String newPin) {
		this.newPin = newPin;
	}

	public keyListener(Main main) {
		this.main = main;
	}
	
	public void setChangeScreen(changeScreen change) {
		this.change = change;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void getLoginPanel() {
		this.login = change.getLoginPanel().getLogin();
	}
	
	public void getChooseValuePanel() {
		this.chooseValue = new chooseValueController(login.getAccClicked());
	}
	
	public void getTransferPanel() {
		this.transfer = change.getTransferPanel().getTransfer();
	}
	
	public void getEnterValue() {
		this.enterValue = change.getEnterValue().getEnter();
	}
	
	public void getChangePin() {
		this.changePin = change.getChangePin().getChange();
	}
	
	public void readScreenKind() {
		kind = change.getNowPanel();
		System.out.println(kind);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		this.readScreenKind();
		String nowPanel = this.kind;
		System.out.println(nowPanel);
		
		value = e.getActionCommand();
		
		if('0'<=value.charAt(0) && value.charAt(0)<='9') {
			if(nowPanel.equals("DangNhap")) {
				this.getLoginPanel();
				login.enterPassword(value);
			}
			else if(nowPanel.equals("ChuyenTien")) {
				this.getTransferPanel();
				transfer.enterValueTransfer(value);
			}
			else if(nowPanel.equals("NhapTien")) {
				this.getEnterValue();
				enterValue.enterValueMoney(value);
			}
			else if(nowPanel.equals("DoiPin") || nowPanel.equals("NhapPinMoi")) {
				this.getChangePin();
				changePin.enterPin(value);
			}
			else if(nowPanel.equals("NhapLaiPin")) {
				this.getChangePin();
				changePin.enterPinAgain(value);
			}
		}
		
		if(value.equals("ENTER")) {
			if(nowPanel.equals("DangNhap")) {
				this.getLoginPanel();

				if(login.checkPassword()==1) {
					System.out.println("change");
					change.setOptionView();
				}
				else {
					login.clearPassword();
					login.callErorr();
				}
			}
			else if(nowPanel.equals("ChuyenTien")) {
				this.getTransferPanel();
				transfer.checkValueTransfer();
				if(transfer.getRet()==0) {
					transfer.clearValueTransfer();
					transfer.callNote();
				}
				else {
					transfer.checkMoney();
					if(transfer.getRet()==1) {
						change.setCompleteView();
					}
					else {
						change.setEnoughMoneyView();
					}
				}
			}
			else if(nowPanel.equals("NhapTien")) {
				this.getEnterValue();
				enterValue.checkValue();
				if(enterValue.getRet()==1) {
					enterValue.checkMoney();
					if(enterValue.getRet()==1) {
						change.setCompleteView();
					}
					else {
						change.setEnoughMoneyView();
					}
				}
				else {
					enterValue.callNote();
					enterValue.clearValueMoney();
				}
			}
			else if(nowPanel.equals("DoiPin")) {
				this.getChangePin();
				changePin.checkPin();
				if(changePin.getRet()==1) {
					this.getLoginPanel();
					change.setChangePinView(login.getAccClicked(), "NhapPinMoi","NHẬP MÃ PIN MỚI", "MÃ PIN PHẢI ĐỦ 6 SỐ");
				}
				else {
					changePin.clearPin();
					changePin.callErorr();
				}
			}
			else if(nowPanel.equals("NhapPinMoi")) {
				this.getChangePin();
				if(changePin.getNewPin().length()==6) {
					this.setNewPin(changePin.getNewPin());
					
					change.setChangePinView(login.getAccClicked(), "NhapLaiPin",
							"NHẬP LẠI MÃ PIN MỚI", "MÃ PIN KHÔNG ĐÚNG, BẠN HÃY NHẬP LẠI!");
				}
				else {
					changePin.clearPin();
					changePin.callErorr();
				}	
			}
			else if(nowPanel.equals("NhapLaiPin")) {
				this.getChangePin();
				changePin.checkPinAgain(this.getNewPin());
				
				if(changePin.getRet()==1) {
					changePin.changePin(this.getNewPin());
					change.setCompleteView();
				}
				else {
					changePin.clearPin();
					changePin.callErorr();
				}
			}
		}
		else if(value.equals("CLEAR")) {
			if(nowPanel.equals("DangNhap")) {
				this.getLoginPanel();
				login.clearPassword();
			}
			else if(nowPanel.equals("NhapTien")) {
				this.getEnterValue();
				enterValue.clearValueMoney();
			}
			else if(nowPanel.equals("ChuyenTien")) {
				this.getTransferPanel();
				transfer.clearValueTransfer();
			}
			else if(nowPanel.equals("DoiPin") || nowPanel.equals("NhapPinMoi")
								|| nowPanel.equals("NhapLaiPin")) {
				this.getChangePin();
				changePin.clearPin();
			}
		}
		else if(value.equals("CANCEL")) {
			if(nowPanel.equals("ChonMenhGia")) {
				change.setMainView();
			}
			else {
				change.setMainView();
			}
		}
		
		if(value.equals("first")) {
			if(nowPanel.equals("TuyChon")) {
				this.getLoginPanel();
				change.setTransferView(login.getAccClicked());
			}
			else if(nowPanel.equals("ChonMenhGia")) {
				this.getChooseValuePanel();
				chooseValue.setValueMoney(1000000);
				chooseValue.checkMoney();
				if(chooseValue.getRet()==1) {
					change.setCompleteView();
				}
			}
		}
		else if(value.equals("second")) {
			if(nowPanel.equals("TuyChon")) {
				this.getLoginPanel();
				change.setAccBalanceView(login.getAccClicked());
			}
			else if(nowPanel.equals("ChonMenhGia")) {
				this.getChooseValuePanel();
				chooseValue.setValueMoney(1500000);
				chooseValue.checkMoney();
				if(chooseValue.getRet()==1) {
					change.setCompleteView();
				}
			}
		}
		else if(value.equals("third")) {
			if(nowPanel.equals("TuyChon")) {
				change.setChooseValueView();
			}
			else if(nowPanel.equals("ChonMenhGia")) {
				this.getChooseValuePanel();
				chooseValue.setValueMoney(2000000);
				chooseValue.checkMoney();
				if(chooseValue.getRet()==1) {
					change.setCompleteView();
				}
			}
		}
		else if(value.equals("fourth")) {
			if(nowPanel.equals("TuyChon")) {
				this.getLoginPanel();
				change.setChangePinView(login.getAccClicked(), "DoiPin",
						"NHẬP MÃ PIN HIỆN TẠI", "MÃ PIN KHÔNG ĐÚNG, VUI LÒNG NHẬP LẠI");
			}
			else if(nowPanel.equals("ChonMenhGia")) {
				this.getChooseValuePanel();
				chooseValue.setValueMoney(500000);
				chooseValue.checkMoney();
				if(chooseValue.getRet()==1) {
					change.setCompleteView();
				}
			}
		}
		else if(value.equals("fifth")) {
			if(nowPanel.equals("TuyChon")) {
				this.getLoginPanel();
				change.setInfoView(login.getAccClicked());
			}
			else if(nowPanel.equals("ChonMenhGia")) {
				this.getChooseValuePanel();
				chooseValue.setValueMoney(200000);
				chooseValue.checkMoney();
				if(chooseValue.getRet()==1) {
					change.setCompleteView();
				}
			}
			else if(nowPanel.equals("ThongTinTK") || nowPanel.equals("HoanThanh")
						|| nowPanel.equals("XemSoDu") || nowPanel.equals("KhongDuTien")) {
				change.setOptionView();
			}
		}
		else if(value.equals("sixth")) {
			if(nowPanel.equals("TuyChon")) {
				change.setMainView();
			}
			else if(nowPanel.equals("ChonMenhGia")) {
				this.getLoginPanel();
				change.setEnterValue(login.getAccClicked());
			}
			else if(nowPanel.equals("ThongTinTK") || nowPanel.equals("HoanThanh")
						|| nowPanel.equals("XemSoDu") || nowPanel.equals("KhongDuTien")) {
				change.setMainView();
			}
		}
		
	}
}
