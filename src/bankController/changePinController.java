package bankController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bankDatabase.loginDatabase;
import bankView.changePinPanel;

public class changePinController {
	private changePinPanel changePin;
	private String value;
	private String pass;
	public int ret;
	public String accClicked;
	private String newPin;

	public String getNewPin() {
		return newPin;
	}

	public void setNewPin(String newPin) {
		this.newPin = newPin;
	}

	public String getAccClicked() {
		return accClicked;
	}

	public void setAccClicked(String accClicked) {
		this.accClicked = accClicked;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public changePinController(changePinPanel changePin) {
		this.changePin = changePin;
	}
	
	public void enterPin(String value) {
		changePin.clearNote();
		
		this.value = value;
				
		char[] tmp = this.changePin.getPasswordField().getPassword();
		pass = new String(tmp);
		if(pass.length()<6) {
			System.out.println(pass);
			this.changePin.setPasswordField(pass+this.value);
			this.setNewPin(pass+this.value);
		}
	}
	
	public void enterPinAgain(String value) {
		changePin.clearNote();
		
		this.value = value;
				
		char[] tmp = this.changePin.getPasswordField().getPassword();
		pass = new String(tmp);
		if(pass.length()<6) {
			System.out.println(pass);
			this.changePin.setPasswordField(pass+this.value);
		}
	}
	
	public void checkPin() {
		this.setRet(0);
		this.setAccClicked(changePin.getAccClicked());
		String sqlSelected = "SELECT * FROM CardInfo"
					+ "	WHERE AccNum = " + changePin.getAccClicked();
		
		try {
			Connection con = loginDatabase.getConnection();
			Statement st = con.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = st.executeQuery(sqlSelected);
			
			while(rs.next()) {
				char[] tmp = this.changePin.getPasswordField().getPassword();
				pass = new String(tmp);
				if(rs.getString("Pin").equals(pass)) {
					this.setRet(1);
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String takeNewPin() {
		char[] tmp = this.changePin.getPasswordField().getPassword();
		pass = new String(tmp);
		
		return pass;
	}
	
	public void checkPinAgain(String newPin) {
		this.setRet(0);
		
		char[] tmp = this.changePin.getPasswordField().getPassword();
		pass = new String(tmp);
		if(newPin.equals(pass) && pass.length()==6) {
			this.setRet(1);
		}
	}
	
	public void changePin(String newPin) {
		String sqlSelected = "SELECT * FROM Owners AS A"
				+ "	INNER JOIN Regist AS B ON A.ID = B.ID"
				+ "		INNER JOIN CardInfo AS C ON B.AccNum = C.AccNum"
				+ "			WHERE B.AccNum = " + changePin.getAccClicked();
		
		String sqlUpdated = "UPDATE Owners AS A"
				+ "	INNER JOIN Regist AS B ON A.ID = B.ID"
				+ "		INNER JOIN CardInfo AS C ON B.AccNum = C.AccNum"
				+ "			SET C.Pin = ?"
				+ "				WHERE B.AccNum = ?";
		
		try {
			
			Connection con = loginDatabase.getConnection();
			Statement st = con.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sqlSelected);
			
			while(rs.next()) {
				PreparedStatement pstmt = con.prepareStatement(sqlUpdated);
				int tmp = Integer.parseInt(newPin);
				
				pstmt.setInt(1, tmp);
				pstmt.setString(2, changePin.getAccClicked());
				
				pstmt.executeUpdate();
				
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clearPin() {
		this.changePin.setPasswordField("");
	}
	
	public void callErorr() {
		this.changePin.callNote();
	}
	
}
