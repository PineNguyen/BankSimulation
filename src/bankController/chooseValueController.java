package bankController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bankDatabase.loginDatabase;

public class chooseValueController {
	private String accClicked;
	private int valueMoney;
	private int nowBalance;
	private int ret;
	
	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public int getNowBalance() {
		return nowBalance;
	}

	public void setNowBalance(int nowBalance) {
		this.nowBalance = nowBalance;
	}

	public int getValueMoney() {
		return valueMoney;
	}

	public void setValueMoney(int valueMoney) {
		this.valueMoney = valueMoney;
	}

	public String getAccClicked() {
		return accClicked;
	}

	public void setAccClicked(String accClicked) {
		this.accClicked = accClicked;
	}

	public chooseValueController(String accClicked) {
		this.setAccClicked(accClicked);
	}
	
	public void checkMoney() {
		this.setRet(0);
		
		String sqlSelected = "SELECT * FROM Owners AS A"
				+ "	INNER JOIN Regist AS B ON A.ID = B.ID"
				+ "		INNER JOIN CardInfo AS C ON B.AccNum = C.AccNum"
				+ "			WHERE B.AccNum = " + this.getAccClicked();
		
		try {
			Connection con = loginDatabase.getConnection();
			Statement st = con.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sqlSelected);
			
			while(rs.next()) {
				if(rs.getInt("Balance")>=this.getValueMoney()) {
					this.setRet(1);
					this.setNowBalance(rs.getInt("Balance"));
					this.processMoney();
				}
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void processMoney() {
		
		String sqlUpdated = "UPDATE Owners AS A"
				+ "	INNER JOIN Regist AS B ON A.ID = B.ID"
				+ "		INNER JOIN CardInfo AS C ON B.AccNum = C.AccNum"
				+ "			SET C.Balance = ?"
				+ "				WHERE B.AccNum = ?";
		
		try {
			
			Connection con = loginDatabase.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sqlUpdated);
			
			pstmt.setInt(1, this.getNowBalance() - this.getValueMoney());
			pstmt.setString(2, this.getAccClicked());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
