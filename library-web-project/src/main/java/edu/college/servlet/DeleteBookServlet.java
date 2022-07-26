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
import edu.college.dao.BookDao;
import edu.college.dao.QueryDao;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(DeleteBookServlet.class);

	public DeleteBookServlet() {
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
		BookDao bd = new BookDao();
		QueryDao qd = new QueryDao();
		String btid = request.getParameter("btid");
		String args[] = { btid };
		int stock = qd.QueryBookStock(args);
		if (stock == 5) {
			int n = bd.deleteBooks(args);
			int c=bd.delNewStocks(args);
			if (n != 0&&c!=0) {
				log.info("ɾ��ͼ��ɹ���");
				response.sendRedirect("ManageBooksServlet");
			}
		} else {
			out.print("<script>alert('�������ж���δ�黹,�޷�ɾ����');location.href='"
					+ pathadd + "/ManageBooksServlet';</script>");
		}
	}
}
