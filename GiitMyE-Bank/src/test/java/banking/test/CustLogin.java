package banking.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import niit.bank.dao.AccountDAO;
import niit.bank.dao.CustomerDAO;
import niit.bank.model.Account;
import niit.bank.model.Customer;



public class CustLogin {
@Test
public void testCaseCustlogin1() {
	
	 Account account = new Account();
	 account.setCustomerid("C4266");
	 account.setPassword("6947-7266");
	 
	 AccountDAO accountDAO=new AccountDAO();
	 
	 assertEquals("Arushi saini",accountDAO.custlogin(account));
	 
}
@Test
public void testCaseCustlogin2() {
	
	 Account account = new Account();
	 account.setCustomerid("C4266");
	 account.setPassword("6947-7266");
	 
	 AccountDAO accountDAO=new AccountDAO();
	 
	 assertEquals("Arushi saini1",accountDAO.custlogin(account));
}
@Test
public void testCaseCustlogin3() {
	
	 Account account = new Account();
	 account.setCustomerid("C4268");
	 account.setPassword("6947-7269");
	 
	 AccountDAO accountDAO=new AccountDAO();
	 
	 assertNull(accountDAO.custlogin(account));
}
@Test
public void testCaseCustviewdata() {
	Customer customer=new Customer();
	
	CustomerDAO customerDAO=new CustomerDAO();
	
	assertNull(customerDAO.viewdata("C4266"));
	assertNotNull(customerDAO.viewdata("C4266"));
	 
}
}
