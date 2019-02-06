package niit.bank.model;
public class Banker {
private String userid;
private String pwd;
private String branchid;
private String userrole;
private String uname;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getBranchid() {
	return branchid;
}
public void setBranchid(String branchid) {
	this.branchid = branchid;
}
public String getUserrole() {
	return userrole;
}
public void setUserrole(String userrole) {
	this.userrole = userrole;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public Banker(String userid, String pwd, String branchid, String userrole, String uname) {
	super();
	this.userid = userid;
	this.pwd = pwd;
	this.branchid = branchid;
	this.userrole = userrole;
	this.uname = uname;
}
public Banker() {
	super();
}
}