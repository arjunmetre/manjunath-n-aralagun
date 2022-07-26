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

import edu.college.bean.BlackListBean;
import edu.college.bean.UserInfoBean;
import edu.college.dao.QueryDao;
import edu.college.dao.UserDao;

@WebServlet("/RechargeServlet")
public class RechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(RechargeServlet.class);
	public RechargeServlet() {
		super();
		  
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String pathadd = request.getContextPath();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String userid = ((UserInfoBean) (session.getAttribute("user")))
				.getUserId();
		UserDao ud = new UserDao();
		QueryDao qd = new QueryDao();
		String money = request.getParameter("money");

		String args[] = { money, userid };
		int n = ud.rechargeUser(args);


		String uid[] = { userid };
		System.out.println("���ݵ�Userid" + userid);

		boolean auser = false;
		String au[] = { userid };
		BlackListBean ArrearageUser = ud.getArrearageUser(au);
		if (ArrearageUser != null)
			auser = true;

		if (auser) {
			int c = ud.rechargeArrearageUser(args);
			System.out.println("��ֵ�������û��Ƿ�ɹ�" + c);

			String arrbalance = qd.QueryArrearageBalance(uid);
			System.out.println("��������ֵ��������ʾ" + arrbalance);
			float ab = Float.parseFloat(arrbalance);
			if (ab >= 0) {
				int cc = ud.deleteArrearageUser(uid);
				System.out.println("ɾ���û��Ƿ�ɹ�" + cc);
			}
		}


		String a[] = { userid };
		UserInfoBean u = ud.getUser(a);
		session.setAttribute("user", u);
		System.out.println(n);
		if (n != 0)
			response.sendRedirect("UserInfoServlet");
		else
			response.sendRedirect("userinfo.jsp");
	}

}
