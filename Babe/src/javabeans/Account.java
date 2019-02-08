package javabeans;

import java.util.Calendar;
import java.util.Date;

public class Account {
	private String SSN;
	private String cardNum;
	private Calendar acctCreationDate;
	private String accountNum;
	
	public Account() {}

	public Calendar getAcctCreationDate() {
		return acctCreationDate;
	}

	public void setAcctCreationDate(Calendar acctCreationDate) {
		this.acctCreationDate = acctCreationDate;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}
	
	public void setAccountNum(String accNum) {
		accountNum = accNum;
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	
}
