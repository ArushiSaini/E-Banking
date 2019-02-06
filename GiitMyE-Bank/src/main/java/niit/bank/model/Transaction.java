package niit.bank.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trandetails")
public class Transaction {
	@Id
	private String tnumber;
	private String accountno;
	private Timestamp dot;
	private String medium_of_transaction;
	private String transaction_type;
	private int transaction_amount;
	private int last_balance;
	private String narration;
	/*private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}*/
	public int getLast_balance() {
		return last_balance;
	}
	public void setLast_balance(int last_balance) {
		this.last_balance = last_balance;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public String getTnumber() {
		return tnumber;
	}
	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public Timestamp getDot() {
		return dot;
	}
	public void setDot(Timestamp dot) {
		this.dot = dot;
	}
	public String getMedium_of_transaction() {
		return medium_of_transaction;
	}
	public void setMedium_of_transaction(String medium_of_transaction) {
		this.medium_of_transaction = medium_of_transaction;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public int getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public Transaction() {
		super();
	}
	public Transaction(String tnumber, String accountno, Timestamp dot, String medium_of_transaction,
			String transaction_type, int transaction_amount, int last_balance, String narration) {
		super();
		this.tnumber = tnumber;
		this.accountno = accountno;
		this.dot = dot;
		this.medium_of_transaction = medium_of_transaction;
		this.transaction_type = transaction_type;
		this.transaction_amount = transaction_amount;
		this.last_balance = last_balance;
		this.narration = narration;
	}
	
}