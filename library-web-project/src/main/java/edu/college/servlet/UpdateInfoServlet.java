package edu.college.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import edu.college.bean.UserInfoBean;
import edu.college.dao.UserDao;

@WebServlet("/UpdateInfoServlet")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(UpdateInfoServlet.class);
	public UpdateInfoServlet() {
		super();
		  
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pathadd = request.getContextPath();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String userid = ((UserInfoBean) (session.getAttribute("user")))
				.getUserId();
		UserDao ud = new UserDao();
		String newname = request.getParameter("newname");
		String newtel = request.getParameter("newtel");
		System.out.println(newname + "**********" + userid);
		String args[] = { newname, newtel, userid };
		int n = ud.updateUserInfo(args);

		String a[] = { userid };
		UserInfoBean u = ud.getUser(a);
		session.setAttribute("user", u);
		System.out.println(n);
		log.info("�����û��ɹ���");
		if (n != 0)
			response.sendRedirect("UserInfoServlet");

	}

}
