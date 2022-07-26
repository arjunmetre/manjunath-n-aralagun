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
import edu.college.bean.BlackListBean;
import edu.college.bean.UserInfoBean;
import edu.college.dao.UserDao;

@WebServlet("/AddBlackListServlet")
public class AddBlackListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(AddBlackListServlet.class);
	
	public AddBlackListServlet() {
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
		String aid = ((AdminBean) (session.getAttribute("admin"))).getAid();
		String userid = request.getParameter("userid");
		String args[] = { userid };
		UserDao ud = new UserDao();
		UserInfoBean user = ud.getUser(args);
		String a[] = { user.getUname(), user.getUserId(), user.getUidCard(),
				user.getBalance() };
		// BlackListBean arruser=new BlackListBean(user.getUname(),user.getUserId(),user.getUidCard());
		int n = ud.addArrearageUser(a);
		if (n != 0) {
			log.info("����Ա��"+aid+"����ͨ�û���"+a[1]+"���������");
			out.print("<script>alert('��Ӻ������ɹ���');location.href='" + pathadd
					+ "/ManageUserServlet';</script>");
		}
	}
}