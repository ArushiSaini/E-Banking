package niit.bank.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="ACCOUNT")
public class Account {
	@Id
	private String accountno; 
	private String customerid;
	
	@Column(name="branchid")
	private String bid;
	
	private String atype;
	private Long openingbalance;
	private Date aod;
	private String astatus;
	private String pin;
	private String password;
	private Date ltdttran;
	//private Branch branch;
	
	@OneToMany
	@JoinColumn(name="accountno")  
	List<Transaction> translist;   
	
	
	
	public List<Transaction> getTranslist() {
		return translist;
	}
	public void setTranslist(List<Transaction> translist) {
		this.translist = translist;
	}
	public Date getLtdttran() {
		return ltdttran;
	}
	public void setLtdttran(Date ltdttran) {
		this.ltdttran = ltdttran;
	}
	/*public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}*/
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public Long getOpeningbalance() {
		return openingbalance;
	}
	public void setOpeningbalance(Long openingbalance) {
		this.openingbalance = openingbalance;
	}
	public Date getAod() {
		return aod;
	}
	public void setAod(Date aod) {
		this.aod = aod;
	}
	public String getAstatus() {
		return astatus;
	}
	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}
	public Account(String accountno, String customerid, String bid, String atype, Long openingbalance, Date aod,
			String astatus, Date ltdttran ) {
		super();
		this.accountno = accountno;
		this.customerid = customerid;
		this.bid = bid;
		this.atype = atype;
		this.openingbalance = openingbalance;
		this.aod = aod;
		this.astatus = astatus;
		this.ltdttran = ltdttran;
		
	}
	public Account() {
		super();
	}	
	
}