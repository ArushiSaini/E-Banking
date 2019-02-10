package niit.bank.controller;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import niit.bank.dao.CustomerDAO;
import niit.bank.model.Customer;

/**
 * Servlet implementation class CustomerReg
 */
@WebServlet("/CustomerReg")
public class CustomerReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Customer cust=  new Customer();
	// SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String customerid="C"+(int)(Math.random()*100)+(int)(Math.random()*100); //request.getParameter("customerid");
	cust.setCustomerid(customerid);
	String customerfname= request.getParameter("custfname");
	cust.setCustfname(customerfname);
	String customerlname= request.getParameter("custlname");
	cust.setCustlname(customerlname);
	String dtofbirth= request.getParameter("dtofbirth");
	try {
		cust.setDtofbirth(df.parse(dtofbirth));
	} catch (ParseException e) {
		e.printStackTrace();
	}
	String guardianname= request.getParameter("guardianname");
	cust.setGuardianname(guardianname);
	String occupation= request.getParameter("occupation");
	cust.setOccupation(occupation);
	String address= request.getParameter("address");
	cust.setAddress(address);
	String contactno= request.getParameter("contactno");
	cust.setContactno(contactno);
	String email= request.getParameter("email");
	cust.setEmail(email);
	String gender= request.getParameter("gender");
	cust.setGender(gender);
	String maritalstatus= request.getParameter("maritalstatus");
	cust.setMaritalstatus(maritalstatus);
	String govtid = request.getParameter("govtid");
	cust.setGovtid(govtid);
	String govtidno = request.getParameter("govtidno");
	cust.setGovtidno(govtidno);
	String citizenship = request.getParameter("citizenship");
	cust.setCitizenship(citizenship);
		
	CustomerDAO cusdao = new CustomerDAO();
	boolean flag = cusdao.insertCustomer(cust);
	if(flag){//login successfull
		request.setAttribute("message","Customer successfully registered");
		RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
		rd.forward(request, response);
	}
	else{
		request.setAttribute("message","Sorry!Customer is not registered");
		RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
		rd.forward(request, response);
		}
}
}

