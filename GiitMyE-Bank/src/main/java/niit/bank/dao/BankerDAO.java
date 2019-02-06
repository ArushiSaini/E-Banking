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

}