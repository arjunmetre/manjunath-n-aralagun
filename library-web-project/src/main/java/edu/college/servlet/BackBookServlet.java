package edu.college.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.college.bean.UserInfoBean;
import edu.college.dao.BookDao;

@WebServlet("/BackBookServlet")
public class BackBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BackBookServlet() {
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
		BookDao bd = new BookDao();
		String bid = request.getParameter("bookid");
		String args[] = { bid, userid };
		int n = bd.backBook(args);
		System.out.println("ͼ��黹�Ƿ�ɹ�" + n);
		if (n != 0) {
			response.sendRedirect("UserInfoServlet");
		}
	}

}
