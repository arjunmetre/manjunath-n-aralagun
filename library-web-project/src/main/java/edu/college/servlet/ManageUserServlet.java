package edu.college.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.college.bean.AdminBean;
import edu.college.bean.UserInfoBean;
import edu.college.dao.UserDao;

@WebServlet("/ManageUserServlet")
public class ManageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageUserServlet() {
		super();
		  
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String aid = ((AdminBean) (session.getAttribute("admin"))).getAid();
		UserDao ud = new UserDao();
		String args[] = null;
		List list = ud.getAllUser(args);
		request.setAttribute("allUser", list);
		request.getRequestDispatcher("manageuser.jsp").forward(request,
				response);
	}

}
