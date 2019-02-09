package niit.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import niit.bank.model.Account;
import niit.bank.model.Banker;
import niit.bank.model.Branch;
import niit.bank.model.Customer;
import niit.bank.model.MyConnection;
import niit.bank.model.Transaction;

public class AccountDAO {
	
public boolean insertaccount(Account a){
	 boolean flag=false;
	  Connection con = null;
	  try {
		  
		  
		  con=new MyConnection().getConnection();
		  con.setAutoCommit(false);
			PreparedStatement smt = con.prepareStatement("insert into account values (?,?,?,?,?,curdate(),?,?,?,curdate())");
			smt.setString(1, a.getAccountno());
			smt.setString(2, a.getCustomerid());
			smt.setString(3, a.getBid());
			smt.setString(4, a.getAtype());
			smt.setLong(5, a.getOpeningbalance().longValue());
			//smt.setDate(6, date);
			smt.setString(6, a.getAstatus());
			smt.setString(7, a.getPin());
			smt.setString(8, a.getPassword());
				
			int result = smt.executeUpdate();
			System.out.println("Result:"+result);
			String tnumber = "TX"+(int)(Math.random()*100)+(int)(Math.random()*100)+(int)(Math.random()*100);
			PreparedStatement smt2 = con.prepareStatement("insert into trandetails values(?,?,now(),?,?,?,?,?)");
			smt2.setString(1, tnumber);	
			smt2.setString(2, a.getAccountno());
			//smt2.setDate(3, date);
			smt2.setString(3, "Cash");
			smt2.setString(4, "Deposit");
			smt2.setLong(5, a.getOpeningbalance().longValue());
			smt2.setLong(6, a.getOpeningbalance().longValue());
			smt2.setString(7,"Opening A/c");
			int result2 = smt2.executeUpdate();
			System.out.println("Result2:"+result2);
			if(result>0 && result2>0) {
				flag = true;
				con.commit();
			}
			else {
				con.rollback();
			}
	  }
	  catch(Exception e) {
		  System.out.println(e);
		  flag = false;
	  }
	  finally {
     	if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  }
	  System.out.println("Flag:"+flag);
	  return flag;	  
      }




public String custlogin(Account ac) {
	String custname=null;
	try {
		Session session=new SessionDao().getSession();
		Customer cust=(Customer) session.get(Customer.class, ac.getCustomerid()) ;//customer class object is obtained // (Customer)query.uniqueResult();
		if(cust!=null) {
			for(Account account:cust.getAccountlist()) {
				if(account.getPassword().equals(ac.getPassword())) {
			         custname=cust.getCustfname()+" "+cust.getCustlname();  break; }
			}
		}
	session.close();
	}
	catch(Exception e)
	{
		System.out.println("Error:"+e);
	}
	return custname;
}

public Account viewdata(Account account){
	Branch branch=new Branch();
	Account ac1 = new Account();
	ac1.setAccountno(account.getAccountno());
		
	Connection con=null;
	try {
	//Class.forName("com.mysql.jdbc.Driver");
	con= new MyConnection().getConnection(); //"jdbc:mysql://localhost:3306/newdb","root","root");
	PreparedStatement smt = con.prepareStatement("select a.accountno,b.bname,a.openingbalance from account a , branch b where b.branchid=a.branchid and a.accountno=?");
	smt.setString(1, account.getAccountno()); 
	//smt.setString(2, branch.getBname());
	//smt.setLong(3, account.getOpeningbalance().longValue());
	ResultSet result = smt.executeQuery();
	if(result.next()) {
		String brname = result.getString(2);
		long balance = result.getLong(3);
		ac1.setOpeningbalance(balance);
		branch.setBname(brname);
		//ac1.setBranch(branch);
		             
	}
	result.close();
	}
	catch (Exception e) {System.out.println(e);  }  
	finally{
	if(con!=null)
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return ac1;
}


public List<Transaction> viewTransactions(String acno){
	List<Transaction> tranlist = null;
	try {
		
		Session session=new SessionDao().getSession();
		Query query= session.createQuery("from Transaction where accountno=:acno order by dot desc");//order by dot desc");
		//query.setParameter("customerid", custid);
		query.setParameter("acno", acno);
		query.setMaxResults(10);
		tranlist=query.list();
		session.close();
	}
	catch(Exception e)
	{
		System.out.println("Error:"+e);
	}
	return tranlist;
}


public List<Transaction> viewTransactions(String acno, String custid){
	List<Transaction> tranlist = null;
	try {
		
		Session session=new SessionDao().getSession();
		Query query= session.createQuery("from Transaction where accountno=:acno order by dot desc");//order by dot desc");
		//query.setParameter("customerid", custid);
		query.setParameter("acno", acno);
		query.setMaxResults(10);
		tranlist=query.list();
		session.close();
	}
	catch(Exception e)
	{
		System.out.println("Error:"+e);
	}
	return tranlist;
}
	
	
	

public List<Transaction> viewTransactions(String acno, String custid, String dtfrom , String dtto){
	List<Transaction> tranlist = null;
	try {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date xdate=null;   
		java.util.Date ydate= null;
		xdate=sdf.parse(dtfrom); //df.parse("12-12-2000");
		ydate=sdf.parse(dtto); //df.parse("12-12-2000");
		
		Session session=new SessionDao().getSession();
		Query query= session.createQuery("from Transaction where accountno=:acno and dot>=:dtfrom  and dot<=:dtto order by dot desc");//order by dot desc");
		//query.setParameter("customerid", custid);
		query.setParameter("acno", acno);
		query.setParameter("dtfrom", xdate);
		query.setParameter("dtto", ydate);
		tranlist=query.list();
		session.close();
	}
	catch(Exception e)
	{
		System.out.println("Error:"+e);
	}
	return tranlist;
}




public List<Account> viewAccountSummary(String cid){
	List<Account> accountlist=null;
	try {
		Session session=new SessionDao().getSession();
		Customer customer=(Customer) session.get(Customer.class, cid) ; // (Customer)query.uniqueResult();
		if(customer!=null) {
			accountlist = customer.getAccountlist();
		}
		
		/*Query query= session.createQuery("from Account where customerid=:customerid");
		query.setParameter("customerid", cid);
		accountlist=query.list();*/
		System.out.println("summary:"+accountlist);
		session.close();		
	}
	catch(Exception e)
	{
		System.out.println("Error:"+e);
	}
	return accountlist;
	  	
}



public List<Transaction> viewTransactions(String acno, String custid, int month, int year){	
	List<Transaction> tranlist = null;
	try {
		System.out.println("sdfdsf");
		Session session=new SessionDao().getSession();
		Query query= session.createQuery("from Transaction where accountno=:acno and month(dot)=:month and year(dot)=:year order by dot desc"); 
		query.setParameter("acno", acno);
		query.setParameter("month", month);
		query.setParameter("year", year);
		tranlist=query.list();
		session.close();
	}
	catch(Exception e)
	{
		System.out.println("Error:"+e);
	}
	return tranlist;
}




public List<Transaction> viewTransactions(String acno, String custid, int year){
	List<Transaction> tranlist = null;
	try {
		Session session=new SessionDao().getSession();
		Query query= session.createQuery("from Transaction where accountno=:acno and year(dot)=:year order by dot desc");
		//query.setParameter("customerid", custid);
		query.setParameter("acno", acno);
		query.setParameter("year", year);
		tranlist=query.list();
		session.close();
		
	}
	catch(Exception e)
	{
		System.out.println("Error:"+e);
	}
	return tranlist;
}

public List<Transaction> viewTransactions(String acno, String custid, int amount, String option){
	
	List<Transaction> tranlist = null;
	try {
		Session session=new SessionDao().getSession();
		if(option.equalsIgnoreCase("less"))
		{
		Query query= session.createQuery("from Transaction where accountno=:acno and  transaction_amount<=:amount order by dot desc");
		//query.setParameter("customerid", custid);
		query.setParameter("acno", acno);
		query.setParameter("amount", amount);
		//query.setParameter("option", option);
		tranlist=query.list();
		}
		else
		{
			Query query= session.createQuery("from Transaction where accountno=:acno and  transaction_amount>=:amount order by dot desc");
			//query.setParameter("customerid", custid);
			query.setParameter("acno", acno);
			query.setParameter("amount", amount);
			//query.setParameter("option", option);
			tranlist=query.list();
		}
		
		session.close();
		
	}
	catch(Exception e)
	{
		System.out.println("Error:"+e);
	}
	return tranlist;

}
}