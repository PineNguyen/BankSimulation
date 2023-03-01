package bankController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bankDatabase.loginDatabase;
import bankView.enterValueMoney;
import bankView.transferPanel;

public class enterValueController {
	private enterValueMoney enterValue;
	private String value;
	private int ret;
	
	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}
	
	public enterValueController(enterValueMoney enterValue) {
		this.enterValue = enterValue;
	}

	public void enterValueMoney(String value) {
		this.enterValue.clearNote();
		
		this.value = value;
		
		String money = this.enterValue.getValueMoney().getText();
		if(money.length()<8) {
			this.enterValue.setValueMoney(money+value);
		}
	}
	
	public void checkValue() {
		this.setRet(1);
		
		try {
			int tmp = Integer.parseInt(enterValue.getValueMoney().getText());
			
			if(tmp%10!=0 || tmp>15000000) {
				this.setRet(0);
			}
		}
		catch(Exception e) {
			this.callEnterValue();
		}
	}
	
	public void checkMoney() {
		this.setRet(0);
		
		int money = Integer.parseInt(enterValue.getValueMoney().getText());
		
		String sqlSelected = "SELECT * FROM Owners AS A"
				+ "	INNER JOIN Regist AS B ON A.ID = B.ID"
				+ "		INNER JOIN CardInfo AS C ON B.AccNum = C.AccNum"
				+ "			WHERE B.AccNum = " + enterValue.getAccClicked();
		
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
				if(rs.getInt("Balance")-2000>=money) {
					this.setRet(1);
					
					PreparedStatement pstmt = con.prepareStatement(sqlUpdated);
					
					pstmt.setInt(1, rs.getInt("Balance") - (money+2000));
					pstmt.setString(2, enterValue.getAccClicked());
					
					pstmt.executeUpdate();
				}
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clearValueMoney() {
		this.enterValue.setValueMoney("");
	}
	
	public void callNote() {
		this.enterValue.setNote();
	}
	
	public void callEnterValue() {
		this.enterValue.setEnterValue();
	}
}
