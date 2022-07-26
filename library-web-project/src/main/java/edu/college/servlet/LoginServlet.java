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

import edu.college.bean.AdminBean;
import edu.college.bean.UserInfoBean;
import edu.college.dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(LoginServlet.class);
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String pathadd = request.getContextPath();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String rand = (String) session.getAttribute("rand");
		String input = request.getParameter("rand");
		int type = Integer.parseInt(request.getParameter("type"));
		System.out.println(input);
		if (type != 0) {
			if (rand.equals(input)) {

				String userid = request.getParameter("userid");
				String password = request.getParameter("password");
				UserDao ud = new UserDao();
				String[] args = { userid, password };
				 System.out.println(userid + "zzzz" + password + "zzzzzzz" +
				 type);
				UserInfoBean uib = null;
				AdminBean ab = null;
				if (type == 1) {
					uib = ud.checkLogin(args);
					if (uib == null)
						out.print("<script>alert('Login failed');location.href='"
								+ pathadd + "/login.jsp';</script>");
					else {
						session.setAttribute("user", uib);
						log.info("��ͨ�û���¼�ɹ���" + uib.getUserId());
						response.sendRedirect("userhome.jsp");
					}
				} else if (type == 2) {
					ab = ud.checkAdminLogin(args);

					if (ab == null)
						out.print("<script>alert('Login Failed');location.href='"
								+ pathadd + "/login.jsp';</script>");
					else {
						System.out.println(ab.getAname());
						session.setAttribute("admin", ab);
						log.info("����Ա��¼�ɹ���" + ab.getAid());
						response.sendRedirect("adminhome.jsp");
					}
				}
			} else {
				out.print("<script>alert('Please enter captcha correctly');location.href='"
						+ pathadd + "/login.jsp';</script>");
			}
		} else {
			out.print("<script>alert('Please select user type ');location.href='" + pathadd
					+ "/login.jsp';</script>");
		}
	}
}