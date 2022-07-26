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

@WebServlet("/UpdatePswServlet")
public class UpdatePswServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(UpdatePswServlet.class);
	public UpdatePswServlet() {
		super();
		  
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String pathadd = request.getContextPath();
		PrintWriter out = response.getWriter();
		String userid = ((UserInfoBean) (session.getAttribute("user")))
				.getUserId();
		UserDao ud = new UserDao();

		String psw1 = request.getParameter("newpsw");
		String psw2 = request.getParameter("conforim");
		String newpsw = null;
		boolean check = false;
		if (psw1.equals(psw2)) {
			newpsw = psw1;
			check = true;
		}
		if (check) {
			String args[] = { newpsw, userid };
			int n = ud.updatePsw(args);

			String a[] = { userid };
			UserInfoBean u = ud.getUser(a);
			session.setAttribute("user", u);
			System.out.println(n);
			if (n != 0) {
				log.info("�޸�����ɹ���");
				response.sendRedirect("login.jsp");
			}else {
				log.info("�޸�����ʧ�ܣ�");
				response.sendRedirect("userinfo.jsp");
			}
		} else {
			out.print("<script>alert('�������벻һ�������������룡');location.href='"
					+ pathadd + "/userinfo.jsp';</script>");
		}

	}

}
