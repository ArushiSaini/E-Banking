package niit.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import niit.bank.model.Account;
import niit.bank.model.Customer;
import niit.bank.model.MyConnection;

public class CustomerDAO {

	public boolean insertCustomer(Customer c){
		boolean flag=true;
		Connection con=null;
		try {
		con=new MyConnection().getConnection();
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date xdate=  c.getDtofbirth(); //df.parse("12-12-2000");
		java.sql.Date date=new java.sql.Date(xdate.getTime());
		PreparedStatement smt = con.prepareStatement("insert into customer values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		smt.setString(1, c.getCustomerid());	
		smt.setString(2, c.getCustfname());	
		smt.setString(3, c.getCustlname());	
		//smt.setString(4, sdf.format(c.getDtofbirth()));	
		smt.setDate(4,date);
		//smt.setString(4, "12-12-2000");// ;;(c.getDtofbirth()));
		smt.setString(5, c.getGuardianname());
		smt.setString(6, c.getOccupation());	
		smt.setString(7, c.getAddress());
		smt.setString(8, c.getContactno());
		smt.setString(9, c.getEmail());
		smt.setString(10, c.getGender());
		smt.setString(11, c.getMaritalstatus());
		smt.setString(12, c.getGovtid());
		smt.setString(13, c.getGovtidno());
		smt.setString(14, c.getCitizenship());
		smt.setString(15, c.getPassword());
		
		int result = smt.executeUpdate();
		if(result==0)
			flag=false; }
		catch (Exception e) {System.out.println(e); flag=false; }  
		finally{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
		
	}
	
	public List<Customer> viewCustomer(String custName){
		List<Customer> postlist = new ArrayList<Customer>();
		Connection con=null;
		try {
		con=new MyConnection().getConnection();
		
		PreparedStatement smt = con.prepareStatement("select * from customer where custfname like '"+custName+"%'");
		//smt.setString(1, custName);
		ResultSet rs = smt.executeQuery();
		while (rs.next())
		{
			Customer b= new Customer();
			b.setCustomerid(rs.getString(1));
			b.setCustfname(rs.getString(2));
			b.setCustlname(rs.getString(3));
			b.setContactno(rs.getString(8));
			b.setEmail(rs.getString(9));
			b.setGender(rs.getString(10));
			postlist.add(b);
		}
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
		return postlist;
	}

/*	public Customer viewdata(String custid){
		Customer b = null;
		Connection con=null;
		try {
		con=new MyConnection().getConnection();
		
		PreparedStatement smt = con.prepareStatement("select * from customer where customerid=?");
		smt.setString(1, custid);
		ResultSet rs = smt.executeQuery();
		while (rs.next())
		{
			b= new Customer();
			//b.setCustomerid(rs.getString(1));
			//b.setCustfname(rs.getString(2));
			//b.setCustlname(rs.getString(3));
			b.setDtofbirth(rs.getDate(4));
			b.setContactno(rs.getString(8));
			b.setEmail(rs.getString(9));
			b.setOccupation(rs.getString(6));
			b.setAddress(rs.getString(7));
			//b.setGender(rs.getString(10));
		
		}
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
		return b;
	}*/
	public String custlogin(Customer customer) {
		String custname=null;
		try {
			Session session=new SessionDao().getSession();
			Customer cust=(Customer) session.get(Customer.class, customer.getCustomerid()) ;//customer class object is obtained // (Customer)query.uniqueResult();
			if(cust!=null) {
				if(cust.getPassword().equals(customer.getPassword())) {
				         custname=cust.getCustfname()+" "+cust.getCustlname();  }
				
			}
		session.close();
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
		return custname;
	}

	
	public Customer viewdata(String custid){
		Customer customer=null;
		try {
			Session session=new SessionDao().getSession();
			customer=(Customer) session.get(Customer.class, custid) ; // (Customer)query.uniqueResult();
			session.close();		
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
		return customer;
	
	}
}