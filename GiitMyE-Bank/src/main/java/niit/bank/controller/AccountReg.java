
package niit.bank.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import niit.bank.dao.AccountDAO;
import niit.bank.model.Account;


/**
 * Servlet implementation class AccountReg
 */
@WebServlet("/AccountReg")
public class AccountReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AccountReg() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		String pin = (int)(Math.random()*100)+""+(int)(Math.random()*100);
		String password = (int)(Math.random()*100)+""+(int)(Math.random()*100)+"-"+(int)(Math.random()*100)+""+(int)(Math.random()*100);
		String customerid = request.getParameter("customerid");
		String bid = request.getParameter("bid");
		String atype = request.getParameter("atype");
		String openingbalance = request.getParameter("openingbalance");
		//String aod = request.getParameter("aod");
        //String dtofbirth= request.getParameter("dtofbirth");
		String astatus = "Active";
		//String ifsccode = request.getParameter("ifsccode");
		String accountno = "A"+(int)(Math.random()*100)+(int)(Math.random()*100)+(int)(Math.random()*100)+bid.substring(1);
		Account account = new Account();
		account.setAccountno(accountno);
		account.setCustomerid(customerid);
		account.setBid(bid);
		account.setAtype(atype);
		account.setPassword(password);
		account.setPin(pin);
		account.setOpeningbalance(new Long(openingbalance));
		/*DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		try {
			account.setAod(df.parse(aod));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		account.setAstatus(astatus);
		
		AccountDAO  acdao = new AccountDAO();
		boolean flag = acdao.insertaccount(account);
		if(flag) {
			request.setAttribute("message","Account is created");
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("message","Account is not created");
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);
	}

	}

}
