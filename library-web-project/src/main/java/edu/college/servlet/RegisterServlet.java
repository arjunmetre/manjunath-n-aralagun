package edu.college.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.college.dao.UserDao;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(RegisterServlet.class);
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String pathadd = request.getContextPath();

		String Uname = request.getParameter("usename");
		String Upsw = request.getParameter("Upsw");
		String UidCard = request.getParameter("idcard");
		String Utel = request.getParameter("phone");
		String UserId = request.getParameter("UserId");
		String Uage = request.getParameter("age");

		String arg[] = { Uname, Uage, UidCard, Utel, UserId, Upsw };
		
		UserDao ud = new UserDao();
		int n = ud.addUser(arg);
		if (n != 0) {
			log.info("Created  "+arg[4]);
			out.print("<script>alert('Done');location.href='" + pathadd
					+ "/login.jsp';</script>");
		} else {
			log.info("Failed to create");
			out.print("<script>alert('Failed');location.href='" + pathadd
					+ "/register.jsp';</script>");
		}
	}
}