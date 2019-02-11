package niit.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import niit.bank.dao.AccountDAO;
import niit.bank.model.Account;

/**
 * Servlet implementation class CustLogin
 */
@WebServlet("/CustLogin")
public class CustLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  /*String accountno = request.getParameter("uid");*/
			String cid = request.getParameter("uid");
		  String password = request.getParameter("password");
		  
		  Account account = new Account();
			//account.setAccountno(accountno);
		  account.setCustomerid(cid);
			account.setPassword(password);

			AccountDAO a= new AccountDAO();
		    String custname = a.custlogin(account);
			if(custname!=null){
				System.out.println("custname111:"+custname);
				HttpSession session = request.getSession(); // default true 
				//			session.setAttribute("accountno",accountno);
				session.setAttribute("custid",cid);
				session.setAttribute("custname",custname);
				//RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
				//rd.forward(request, response);
				response.sendRedirect("CustHome.jsp");
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<center><h1>Sorry! Try again!!!!!</h1></center>");
				//RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				//rd.include(request, response);
				response.sendRedirect("Main.jsp");
			}
		}
	}