package servlet;

import java.io.IOException;
import java.util.Random;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userdao;
import model.CustomerUser;
import model.User;
import services.Service;

/**
 * Servlet implementation class Server
 */
@WebServlet("/Server")
public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Server() {
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
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("register"))
		{
			User u = new User();
			u.setFirstname(request.getParameter("firstname"));
			u.setLastname(request.getParameter("lastname"));
			u.setEmail(request.getParameter("email"));
			u.setContact( Long.parseLong( request.getParameter("contact")));
			u.setPassword(request.getParameter("password"));
			
			System.out.print(u);
			Userdao.insertuser(u);
			request.getRequestDispatcher("login2.jsp").forward(request, response);
			
		}
		else if(action.equalsIgnoreCase("loginned")) {
			User u  =new User();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
		 	User u1 = Userdao.checkLogin(u);
		 	if(u1 == null) {
		 		request.setAttribute("msg", "email or password is incorrect");
		 		request.getRequestDispatcher("login.jsp").forward(request, response);
		 	}
		 	else {
		 		HttpSession session = request.getSession();
		 		session.setAttribute("data", u1);
		 		request.getRequestDispatcher("seller-home.jsp").forward(request, response);
		 	}
		}
		else if(action.equalsIgnoreCase("update"))
		{
			User u1 = new User();
			u1.setId(Integer.parseInt(request.getParameter("id")));
			u1.setFirstname(request.getParameter("firstname"));
			u1.setLastname(request.getParameter("lastname"));		
			u1.setEmail(request.getParameter("email"));
			u1.setContact(Long.parseLong(request.getParameter("contact")));
//			u.setPassword(request.getParameter("password"));
		    Userdao.update(u1);
		    HttpSession session = request.getSession();
		    session.setAttribute("data", u1);
		    request.getRequestDispatcher("seller-home.jsp").forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("change password"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
            String op = request.getParameter("op");
            String np = request.getParameter("np");
            String cp = request.getParameter("cp");
			boolean flag = Userdao.checkpassword(id, op);
			System.out.print(flag);
			if(flag == true)
			{
				if(np.equals(cp)) {
					
					Userdao.changepassword(id, np);
					System.out.println("password chnaged");
				    response.sendRedirect("seller-home.jsp");
				}
				else
				{
					request.setAttribute("msg1", "new password or confirm password not matched");
					request.getRequestDispatcher("my-account.jsp").forward(request, response);
					
				}
			
		}
			else
			{
				request.setAttribute("msg", "old password is incorrect");
				request.getRequestDispatcher("my-account.jsp").forward(request, response);
			}
	}
		else if(action.equalsIgnoreCase("get otp")) {
			String email = request.getParameter("email");
			boolean flag = Userdao.checkemail(email);
			System.out.println(flag);
			if(flag == true) {
				Service s =  new Service();
				Random r = new Random();
				int num = r.nextInt(9999);
				System.out.println(num);
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("seller-verifyotp.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "email id not registered");
				request.getRequestDispatcher("forgot password.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("verify"))
		{
			String email = request.getParameter("email");
			int otp = Integer.parseInt(request.getParameter("otp"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			System.out.println(email+otp+" "+otp2);
			if(otp == otp2)
			{
				request.setAttribute("email", email);
				request.getRequestDispatcher("seller-change-password2.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("email", email);
				request.setAttribute("otp", otp);
				request.setAttribute("msg", "otp does not matched");
				request.getRequestDispatcher("seller-verifyotp.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("new password"))
		{  
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if(np.equals(cnp)) {
				Userdao.forgotpassword(email, cnp);
				request.getRequestDispatcher("login2.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "np and cnp not matched");
				request.getRequestDispatcher("seller-change-password2.jsp").forward(request, response);
			}
		}
		
	}
}
