

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
		
		String luser=request.getParameter("lmail");
		String lpwd=request.getParameter("lpwd");
		
//		pw.print(luser+"\t"+lpwd);
		
		Loginpojo lp=new Loginpojo(luser,lpwd);
//		lp.setLuser(luser);
//		lp.setLpwd(lpwd);
//		
		Logindao ld=new Logindao();
		try {
			String str=ld.validate(lp);
			if(str.equals("success"))
			{   
				pw.print("login successful");
				RequestDispatcher re=request.getRequestDispatcher("welcome.html");
				re.forward(request, response);
//				response.sendRedirect("https://www.tutorialcup.com/interview/sql-interview-questions/sql-query.htm");
			}
			else
			{   pw.print("login invalid");
				RequestDispatcher re=request.getRequestDispatcher("login.html");
				re.include(request, response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
