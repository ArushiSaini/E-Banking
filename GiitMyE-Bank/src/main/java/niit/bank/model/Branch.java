package niit.bank.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BRANCH")
public class Branch {
@Id	
private String branchid;

   private String bname;
   private String bcity;
   private String ifsccode;
@OneToMany
@JoinColumn(name="bid")  
List<Account> accountlist;   
   

public List<Account> getAccountlist() {
	return accountlist;
}
public void setAccountlist(List<Account> accountlist) {
	this.accountlist = accountlist;
}
public String getBranchid() {
	return branchid;
}
public void setBranchid(String branchid) {
	this.branchid = branchid;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getBcity() {
	return bcity;
}
public void setBcity(String bcity) {
	this.bcity = bcity;
}
public String getIfsccode() {
	return ifsccode;
}
public void setIfsccode(String ifsccode) {
	this.ifsccode = ifsccode;
}
public Branch(String branchid, String bname, String bcity, String ifsccode) {
	super();
	this.branchid = branchid;
	this.bname = bname;
	this.bcity = bcity;
	this.ifsccode = ifsccode;
}
public Branch() {
	super();
}
   
}
