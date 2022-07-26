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
import edu.college.dao.UserDao;


@WebServlet("/CancelBlackListServlet")
public class CancelBlackListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(CancelBlackListServlet.class);
    public CancelBlackListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String pathadd = request.getContextPath();
		PrintWriter out = response.getWriter();
		String aid = ((AdminBean) (session.getAttribute("admin"))).getAid();
		String userid = request.getParameter("userid");
		String args[] = { userid };
		UserDao ud = new UserDao();
		int n = ud.deleteArrearageUser(args);
		if (n != 0) {
			log.info("ȡ���������ɹ���");
			out.print("<script>alert('ȡ���������ɹ���');location.href='" + pathadd
					+ "/ManageUserServlet';</script>");
		}
	}

}
