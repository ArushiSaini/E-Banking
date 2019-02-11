package niit.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import niit.bank.model.Banker;
import niit.bank.model.MyConnection;
import niit.bank.model.Transaction;

public class BankerDAO {
	
public String login(Banker banker){
String flag=null;
Connection con=null;
try {
con=new MyConnection().getConnection();
PreparedStatement smt = con.prepareStatement("select * from banker where userid=? and pwd=?");
	smt.setString(1,banker.getUserid());
	smt.setString(2, banker.getPwd());
	ResultSet result = smt.executeQuery();
	if(result.next())
		flag=result.getString(3); 
	result.close();
	System.out.println("flag="+flag);
	}
	catch (Exception e) {System.out.println(e); flag=null; }  
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

public boolean updateaccount(Transaction tran){
	boolean flag=false;
	Connection con=null;
	try {
	con=new MyConnection().getConnection();
	con.setAutoCommit(false);
	
	PreparedStatement smt1 =null;
	if(tran.getTransaction_type().equalsIgnoreCase("Withdraw"))
	{
		//smt1=con.prepareStatement("update account set openingbalance=openingbalance-? where accountno=? and openingbalance-?>=3000");
		smt1=con.prepareStatement("update account set openingbalance=openingbalance-?, ltdttran=curdate()  where accountno=? and openingbalance-?>=3000");
		smt1.setInt(1, tran.getTransaction_amount());	
		smt1.setString(2, tran.getAccountno());	
		smt1.setInt(3, tran.getTransaction_amount());	
	}
	else {
		//smt1=con.prepareStatement("update account set openingbalance=openingbalance+? where accountno=?");
		smt1=con.prepareStatement("update account set openingbalance=openingbalance+?, ltdttran=curdate() where accountno=?");
		smt1.setInt(1, tran.getTransaction_amount());	
		smt1.setString(2, tran.getAccountno());	
	}
	
	int result1 = smt1.executeUpdate();
	
	//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	//DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	/*java.util.Date xdate=  tran.getDot(); //df.parse("12-12-2000");
	java.sql.Date date=new java.sql.Date(xdate.getTime());*/
	
	
	PreparedStatement smt2 = con.prepareStatement("insert into trandetails values(?,?,now(),?,?,?,?,?)");
	smt2.setString(1, tran.getTnumber());	
	smt2.setString(2, tran.getAccountno());
	//smt2.setDate(3, date);
	smt2.setString(3, tran.getMedium_of_transaction());
	smt2.setString(4, tran.getTransaction_type());
	smt2.setInt(5, tran.getTransaction_amount());
	smt2.setInt(6, tran.getTransaction_amount());
	smt2.setString(7,tran.getNarration());
	int result2 = smt2.executeUpdate();
	
	if(result1>0 && result2>0) {
		con.commit();
		flag=true;
	}
	}
	catch (Exception e) {System.out.println(e); flag=false; 
	try {
		con.rollback();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	}  
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

}