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
import edu.college.dao.BookDao;
import edu.college.dao.QueryDao;
import edu.college.dao.UserDao;

@WebServlet("/BorrowServlet")
public class BorrowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(BorrowServlet.class);
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
		String userid = ((UserInfoBean) (session.getAttribute("user")))
				.getUserId();
		UserInfoBean uall = (UserInfoBean) session.getAttribute("user");
		boolean auser = false;
		UserDao ud = new UserDao();
		String au[] = { userid };
		BlackListBean ArrearageUser = ud.getArrearageUser(au);
		if (ArrearageUser == null)
			auser = true;
		if (auser) {
			String ISBN = request.getParameter("isbn");
			QueryDao qd = new QueryDao();
			String[] args = { ISBN };
			int n = qd.QueryBookStock(args);
			if (n == 0) { 
				out.print("<script>alert('�������ĵ�ͼ��Ŀǰû�п�棡');location.href='"
						+ pathadd + "/searchbooks.jsp';</script>");
			} else if (n != 0) {  
				BookDao bd = new BookDao();
				String[] arg = { ISBN, userid };
				bd.borrowBook(arg);
				Double ba = Double.parseDouble(uall.getBalance());
				boolean cba = false;
				if (ba >= 0) {
					cba = true;
				}
				if (cba) {
					log.info("���ĳɹ�");
					out.print("<script>alert('��ϲ����ĳɹ���');location.href='"
							+ pathadd + "/searchbooks.jsp';</script>");
				} else {
					log.info("���ĳɹ������û�Ƿ��");
					out.print("<script>alert('��ϲ����ĳɹ���������Ƿ��,�뾡���ֵ�ޣ�');location.href='"
							+ pathadd + "/UserInfoServlet';</script>");
				}
			}

		} else {
			log.info("����ʧ�ܣ��û�Ƿ��");
			out.print("<script>alert('����Ƿ���ѱ�����������޷����Ķ���,�뾡���ֵ��');location.href='"
					+ pathadd + "/UserInfoServlet';</script>");
		}
	}
}