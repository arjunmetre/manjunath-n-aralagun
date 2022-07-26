package edu.college.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import edu.college.bean.AdminBean;
import edu.college.bean.BookInfoBean;
import edu.college.bean.UserInfoBean;
import edu.college.dao.BookDao;
import edu.college.dao.QueryDao;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(AddBookServlet.class);
	public AddBookServlet() {
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
		QueryDao qd=new QueryDao();
		String args[]=null;
		List<BookInfoBean> listnewbooks=qd.QueryNewBooks(args);
		request.setAttribute("listnewbooks", listnewbooks);
		log.info("����Ա"+aid+"���ͼ��ɹ�");
		request.getRequestDispatcher("addbook.jsp").forward(request,
				response);
		
		
		
		
		
		
		
		
		
		

	}

}
