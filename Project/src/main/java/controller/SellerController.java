package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.SellerDao;
import Model.Seller;
import services.Service;

/**
 * Servlet implementation class SellerController
 */
@WebServlet("/SellerController")
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerController() {
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
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("register")) {
			Seller s = new Seller();
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			SellerDao.insertSeller(s);
			response.sendRedirect("seller-login.jsp");
		}
		else if(action.equalsIgnoreCase("login")) {
			Seller u  =new Seller();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			Seller u1 = SellerDao.sellerLogin(u);
		 	if(u1 == null) {
		 		request.setAttribute("validate", "email or password is incorrect");
		 		request.getRequestDispatcher("seller-login.jsp").forward(request, response);
		 	}
		 	else {
		 		HttpSession session = request.getSession();
		 		session.setAttribute("data", u1);
		 		request.getRequestDispatcher("seller-index.jsp").forward(request, response);
		 	}
		}
		else if(action.equalsIgnoreCase("update")) {
			Seller s = new Seller();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			SellerDao.updateProfile(s);
			HttpSession session = request.getSession();
	 		session.setAttribute("data", s);
	 		request.getRequestDispatcher("seller-index.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("change password")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = SellerDao.checkPassword(id, op);
			System.out.println(flag);
			if(flag == true) {
				if(np.equals(cnp)) {
					SellerDao.changePassword(id, np);
					response.sendRedirect("seller-index.jsp");
				}
				else {
					request.setAttribute("msg1", "new password and confirm new password not matched");
					request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "old password incorrect");
				request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("get otp")) {
			String email = request.getParameter("email");
			boolean flag = SellerDao.checkEmail(email);
			System.out.println(email);
			System.out.println(flag);
			System.out.println(flag);
			if(flag == true) {
				Service s = new Service();
				Random r = new Random();
				int num = r.nextInt(9999);
				System.out.println(num);
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("seller-verify-otp.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "email id not registered");
				request.getRequestDispatcher("seller-forgot-password.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			System.out.println(email+otp1+" : "+otp2);
			if(otp1==otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("seller-change-pass.jsp").forward(request, response);
			}
			else {
				request.setAttribute("email", email);
				request.setAttribute("otp", otp1);
				request.setAttribute("msg", "otp not matched");
				request.getRequestDispatcher("seller-verify-otp.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("new password")) {
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if(np.equals(cnp)) {
				SellerDao.forgotPassword(email, np);
				response.sendRedirect("seller-login.jsp");
			}
			else {
				request.setAttribute("msg", "np and cnp not matched");
				request.getRequestDispatcher("seller-change-pass.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("aupdate")) {
			Seller s = new Seller();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			SellerDao.updateProfile(s);
	 		response.sendRedirect("admin-seller-list.jsp");
		}
	}

}
