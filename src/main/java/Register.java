

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
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
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	String rfname=request.getParameter("rfname");
	String rlname=request.getParameter("rlname");
	String rmail=request.getParameter("rmail");
	String rpwd=request.getParameter("rpwd");
	String rgender=request.getParameter("rgender");
	String rcountry=request.getParameter("rcountry");
	String rcont=request.getParameter("rcont");
	
	registerpojo rp=new registerpojo();
	rp.setRfname(rfname);
	rp.setRlname(rlname);
	rp.setRmail(rmail);
	rp.setRpwd(rpwd);
	rp.setRgender(rgender);
	rp.setRcountry(rcountry);
	rp.setRcont(Integer.parseInt(rcont));
	
	
	Registerdao rdao= new Registerdao();
	try {
		String str=rdao.adduser(rp);
		if(str.equals("success"))
		{
			RequestDispatcher red=request.getRequestDispatcher("login.html");
			red.forward(request, response);
		}
		else
		{
			
			RequestDispatcher red=request.getRequestDispatcher("register.html");
			red.include(request, response);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}

}


//
//registerdao rd=new registerdao();
//try {
//	String str=rd.adduser(rp);
//	if(str.equals("success"))
//	{
//		RequestDispatcher red=request.getRequestDispatcher("login.html");
//		red.forward(request, response);
//	}
//	else
//	{
//		
//		RequestDispatcher red=request.getRequestDispatcher("register.html");
//		red.include(request, response);
//	}
//} catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//
//
//}