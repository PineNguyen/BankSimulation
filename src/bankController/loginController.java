package bankController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bankDatabase.loginDatabase;
import bankView.loginPanel;

public class loginController {
	private loginPanel login;
	private String value;
	private String pass;
	private String pinCode;
	private String accClicked;
	
	public String getAccClicked() {
		return accClicked;
	}

	public void setAccClicked(String accClicked) {
		this.accClicked = accClicked;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public loginController(loginPanel login) {
		this.login = login;
	}
	
	public void enterPassword(String value) {
		login.clearLabelErorr();
		
		this.value = value;
				
		char[] tmp = this.login.getPasswordField().getPassword();
		pass = new String(tmp);
		if(pass.length()<6) {
			this.login.setPasswordField(pass+this.value);
		}
	}
	
	public int checkPassword() {
		int ret = 0;
		this.setAccClicked(login.getAccClicked());
		String sqlSelected = "SELECT * FROM CardInfo"
					+ "	WHERE AccNum = " + this.getAccClicked();
		
		if(this.getAccClicked()==null) {
			ret = 2;
		}
		else {
			try {
				Connection con = loginDatabase.getConnection();
				Statement st = con.createStatement(
						ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

				ResultSet rs = st.executeQuery(sqlSelected);
				
				while(rs.next()) {
					this.setPinCode(rs.getString("Pin"));
					char[] tmp = this.login.getPasswordField().getPassword();
					pass = new String(tmp);
					if(this.getPinCode().equals(pass)) {
						ret = 1; 
					}
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
	public void clearPassword() {
		this.login.setPasswordField("");
	}
	
	public void callErorr() {
		this.login.setLabelErorr();
	}
	
	public void callChooseAcc() {
		this.login.setChooseAcc();
	}
	
	public void clearChooseAcc() {
		this.login.clearChooseAcc();
	}
}
