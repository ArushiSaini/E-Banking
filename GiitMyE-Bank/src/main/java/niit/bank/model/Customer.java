package niit.bank.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Customer")
public class Customer {
	@Id
	private String customerid ;
	private String custfname ;
	private String custlname ;
	private Date dtofbirth;
	private String guardianname ;
	private String occupation;
	private String address ;
	private String contactno;
	private String email ;
	private String gender ;
	private String maritalstatus ;
	private String govtid ;
	private String govtidno ;
	private String citizenship ;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="customerid")  
	List<Account> accountlist;
	
	public List<Account> getAccountlist() {
		return accountlist;
	}
	public void setAccountlist(List<Account> accountlist) {
		this.accountlist = accountlist;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustfname() {
		return custfname;
	}
	public void setCustfname(String custfname) {
		this.custfname = custfname;
	}
	public String getCustlname() {
		return custlname;
	}
	public void setCustlname(String custlname) {
		this.custlname = custlname;
	}
	public Date getDtofbirth() {
		return dtofbirth;
	}
	public void setDtofbirth(Date dtofbirth) {
		this.dtofbirth = dtofbirth;
	}
	public String getGuardianname() {
		return guardianname;
	}
	public void setGuardianname(String guardianname) {
		this.guardianname = guardianname;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public String getGovtid() {
		return govtid;
	}
	public void setGovtid(String govtid) {
		this.govtid = govtid;
	}
	public String getGovtidno() {
		return govtidno;
	}
	public void setGovtidno(String govtidno) {
		this.govtidno = govtidno;
	}
	public String getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	public Customer(String customerid, String custfname, String custlname, Date dtofbirth, String guardianname,
			String occupation, String address, String contactno, String email, String gender, String maritalstatus,
			String govtid, String govtidno, String citizenship) {
		super();
		this.customerid = customerid;
		this.custfname = custfname;
		this.custlname = custlname;
		this.dtofbirth = dtofbirth;
		this.guardianname = guardianname;
		this.occupation = occupation;
		this.address = address;
		this.contactno = contactno;
		this.email = email;
		this.gender = gender;
		this.maritalstatus = maritalstatus;
		this.govtid = govtid;
		this.govtidno = govtidno;
		this.citizenship = citizenship;
	}
	public Customer() {
		super();
	}


}
