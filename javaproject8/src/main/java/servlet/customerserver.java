package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userdao;
import dao.customerdao;
import model.CustomerUser;

/**
 * Servlet implementation class customerserver
 */
@WebServlet("/customerserver")
public class customerserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerserver() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		String action = request.getParameter("action");
		
	    if(action.equalsIgnoreCase("register"))
		{
			CustomerUser u = new CustomerUser();
			u.setFirstname(request.getParameter("firstname"));
			u.setLastname(request.getParameter("lastname"));
			u.setEmail(request.getParameter("email"));
			u.setContact( Long.parseLong( request.getParameter("contact")));
			u.setPassword(request.getParameter("password"));
			
			System.out.print(u);
			customerdao.insertcustomer(u);
			request.getRequestDispatcher("customer-login.jsp").forward(request, response);
			
		}
	    else if(action.equalsIgnoreCase("loginned"))
		{
			CustomerUser u = new CustomerUser();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
		    CustomerUser u1 = customerdao.checklogin(u);
		    if(u1 == null)
		    {
		    	request.setAttribute("validate", "incorrect email or password");
		    	request.getRequestDispatcher("customer-login.jsp").forward(request, response);
		    }
		    else
		    {
		    	HttpSession session = request.getSession();
		    	session.setAttribute("data", u1);
		    	request.getRequestDispatcher("customer-home.jsp").forward(request, response);
		    }
		}
	    else if(action.equalsIgnoreCase("update"))
		{
			CustomerUser u = new CustomerUser();
			u.setId(Integer.parseInt(request.getParameter("id")));
			u.setFirstname(request.getParameter("firstname"));
			u.setLastname(request.getParameter("lastname"));		
			u.setEmail(request.getParameter("email"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			
			customerdao.updateCustomer(u);
		   request.getRequestDispatcher("customer-home.jsp").forward(request, response);
			
		}
		
	}

}
