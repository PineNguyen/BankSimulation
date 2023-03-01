package bankController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bankDatabase.loginDatabase;
import bankView.transferPanel;

public class transferController {
	private String value;
	private transferPanel transfer;
	private int ret;
	
	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public transferController(transferPanel transfer) {
		this.transfer = transfer;
	}
	
	public void enterValueTransfer(String value) {
		this.transfer.clearNote();
		
		this.value = value;
		
		String money = this.transfer.getValueTrans().getText();
		if(money.length()<8) {
			this.transfer.setValueTrans(money+value);
		}
	}
	
	public void checkValueTransfer() {
		this.setRet(1);
		
		try {
			int tmp = Integer.parseInt(transfer.getValueTrans().getText());
			
			if(tmp%10!=0 || tmp>20000000) {
				this.setRet(0);
			}
		}
		catch(Exception e) {
			this.callEnterNote();
		}
	}
	
	public void checkMoney() {
		this.setRet(0);
		
		int money = Integer.parseInt(transfer.getValueTrans().getText());
		
		String sqlSelected = "SELECT * FROM Owners AS A"
				+ "	INNER JOIN Regist AS B ON A.ID = B.ID"
				+ "		INNER JOIN CardInfo AS C ON B.AccNum = C.AccNum"
				+ "			WHERE B.AccNum = " + transfer.getNowAcc();
		
		String sqlUpdated = "UPDATE Owners AS A"
				+ "	INNER JOIN Regist AS B ON A.ID = B.ID"
				+ "		INNER JOIN CardInfo AS C ON B.AccNum = C.AccNum"
				+ "			SET C.Balance = ?"
				+ "				WHERE B.AccNum = ?";
		
		try {
			Connection con = loginDatabase.getConnection();
			Statement st = con.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sqlSelected);
			
			while(rs.next()) {
				if(rs.getInt("Balance")-2000>=money && transfer.getAccClicked()!=null) {
					this.setRet(1);
					
					PreparedStatement pstmt = con.prepareStatement(sqlUpdated);
					
					pstmt.setInt(1, rs.getInt("Balance") - (money + 2000));
					pstmt.setString(2, transfer.getNowAcc());
					
					pstmt.executeUpdate();
					
					this.transfer();
				}
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void transfer() {
		String sqlSelected = "SELECT * FROM Owners AS A"
				+ "	INNER JOIN Regist AS B ON A.ID = B.ID"
				+ "		INNER JOIN CardInfo AS C ON B.AccNum = C.AccNum"
				+ "			WHERE B.AccNum = " + transfer.getAccClicked();
		
		String sqlUpdated = "UPDATE Owners AS A"
				+ "	INNER JOIN Regist AS B ON A.ID = B.ID"
				+ "		INNER JOIN CardInfo AS C ON B.AccNum = C.AccNum"
				+ "			SET C.Balance = ?"
				+ "				WHERE B.AccNum = ?";
		
		try {
			int money = Integer.parseInt(transfer.getValueTrans().getText());
			
			Connection con = loginDatabase.getConnection();
			Statement st = con.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sqlSelected);
			
			while(rs.next()) {
				PreparedStatement pstmt = con.prepareStatement(sqlUpdated);
				
				pstmt.setInt(1, rs.getInt("Balance") + money);
				pstmt.setString(2, transfer.getAccClicked());
				
				pstmt.executeUpdate();
				
			}	
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void labelName(String accClicked) {
		String sqlSelected = "SELECT * FROM Owners AS A"
				+ "	INNER JOIN Regist AS B ON A.ID = B.ID"
				+ "		INNER JOIN CardInfo AS C ON B.AccNum = C.AccNum"
				+ "			WHERE B.AccNum = " + accClicked;
		
		try {
			Connection con = loginDatabase.getConnection();
			Statement st = con.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sqlSelected);
			
			
			while(rs.next()) {
				if(accClicked.equals(rs.getString("AccNum"))) {
					transfer.setLblNameAcc(rs.getString("OwnerName"));
				}
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkAcc() {
		this.setRet(1);
		
		if(transfer.getAccClicked()==null) {
			this.setRet(0);
		}
	}
	
	public void clearValueTransfer() {
		this.transfer.setValueTrans("");
	}
	
	public void callNote() {
		this.transfer.setNote();
	}
	
	public void callChooseAcc() {
		this.transfer.setChooseAcc();
	}
	
	public void clearChooseAcc() {
		this.transfer.clearChooseAcc();
	}
	
	public void callEnterNote() {
		this.transfer.enterValueNote();
	}
}
