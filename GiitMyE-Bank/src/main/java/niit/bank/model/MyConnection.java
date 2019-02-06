package niit.bank.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MyConnection {
	
	public Connection getConnection() {
		Connection con=null;
		try {
		/*Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bankdatabase","root","9478038987");*/
			
			InputStream in=this.getClass().getClassLoader().getResourceAsStream("MyProp.properties");
			Properties prop=new Properties();
			prop.load(in);
			String uname=prop.getProperty("username");
			String pwd=prop.getProperty("password");
			String url=prop.getProperty("url");
			String driver=prop.getProperty("driver");
			
		Class.forName(driver);
		con=DriverManager.getConnection(url,uname,pwd);
		}
		catch (Exception e) {System.out.println(e); }  
		return con;
	}

}
