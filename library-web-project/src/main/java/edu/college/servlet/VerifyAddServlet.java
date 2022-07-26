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
import edu.college.bean.BookInfoBean;
import edu.college.dao.BookDao;
import edu.college.dao.QueryDao;


@WebServlet("/VerifyAddServlet")
public class VerifyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(VerifyAddServlet.class);

	public VerifyAddServlet() {
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
		String btids[] = request.getParameterValues("choose");
		QueryDao qd = new QueryDao();
		BookDao bd = new BookDao();
		int n = 1;
		for (int i = 0; i < btids.length; i++) {
			System.out.println("��" + i + "�ζ���ͼ����" + btids[i]);
			String args[] = { btids[i] };
			BookInfoBean book = qd.QueryNewBook(args);
			String bookinfo[] = { book.getISBN(), book.getTypeId(),
					book.getBookname(), book.getWriter(), book.getTranslator(),
					book.getPublisher(), book.getDate(), book.getPrice() };
			int addn = bd.addBooks(bookinfo);
			int adds = bd.addNewStocks(args);
			System.out.println("��" + i + "����ӿ�����Ƿ�ɹ�" + adds);
			int deln = bd.deleteNewBooks(args);
			System.out.println("��" + i + "��ɾ��ͼ���Ƿ�ɹ�" + deln);
			n = addn * deln;
		}
		System.out.println("�����Ƿ�ɹ���" + n);
		if (n == 1) {
			log.info("�����ɹ���");
			out.print("<script>alert('�����ɹ���');location.href='" + pathadd
					+ "/AddBookServlet';</script>");
			 response.sendRedirect("AddBookServlet");
		}
	}

}
