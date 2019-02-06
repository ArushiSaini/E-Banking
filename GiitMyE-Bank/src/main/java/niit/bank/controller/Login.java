package niit.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import niit.bank.dao.BankerDAO;
import niit.bank.model.Banker;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		String userid = request.getParameter("userid");
  		String pwd = request.getParameter("pwd");
  		
  		Banker bank = new Banker();
  		bank.setUserid(userid);
  		bank.setPwd(pwd);

  		BankerDAO b= new BankerDAO();
  	    String flag = b.login(bank);
  		if(flag!=null){
  			HttpSession session = request.getSession(); // default true 
  			session.setAttribute("userid",userid);		
  			session.setAttribute("uname",flag);
  		//	RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
  		//	rd.include(request, response);
  			response.sendRedirect("AdminHome.jsp");
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