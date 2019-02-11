package niit.bank.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import niit.bank.dao.BankerDAO;
import niit.bank.model.Transaction;

/**
 * Servlet implementation class UpdateAccountReg
 */
@WebServlet("/UpdateAccountReg")
public class UpdateAccountReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccountReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		Transaction uaccount = new Transaction();
		String tnumber = "TX"+(int)(Math.random()*100)+(int)(Math.random()*100)+(int)(Math.random()*100);
		uaccount.setTnumber(tnumber);
		String accountno= request.getParameter("accountno");
		uaccount.setAccountno(accountno);
		/*String dot = request.getParameter("dot");
		try {
			uaccount.setDot(sdf.parse(dot));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DATE"+dot);*/
		String medium_of_transaction = request.getParameter("medium_of_transaction");
		uaccount.setMedium_of_transaction(medium_of_transaction);
		String transaction_type = request.getParameter("transaction_type");
		uaccount.setTransaction_type(transaction_type);
		String transaction_amount = request.getParameter("transaction_amount");
		uaccount.setTransaction_amount(Integer.parseInt(transaction_amount));
		String narration = request.getParameter("narration");
		uaccount.setNarration(narration);
		
		BankerDAO  bankerdao = new BankerDAO();
		boolean flag = bankerdao.updateaccount(uaccount);
		if(flag) {
			request.setAttribute("message","Updation Done");
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("message","Sorry! Updation Failed");
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);
	}

	}

}