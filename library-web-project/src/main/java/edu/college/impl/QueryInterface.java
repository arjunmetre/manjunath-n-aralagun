package edu.college.impl;

import java.util.List;

import edu.college.bean.BookInfoBean;
import edu.college.bean.BookTypeBean;
import edu.college.bean.BorrowRecordBean;

public interface QueryInterface {
	public List<BorrowRecordBean> QueryBorrowRecord(String[] args);

	public List<BookInfoBean> QueryKindsBooks(String[] args);

	public BookInfoBean QueryBook(String[] args);

	public int QueryBookStock(String[] args);

	public List<BookInfoBean> pageList(int page, int pageContent, String type);

	public String queryTypeName(String[] args);

	public List<BookTypeBean> queryAllTypeName(String[] args);

	public List<BookInfoBean> QuerySearchBooks(String[] args, String a[]);

	public int count(String[] args);

	public List<BookInfoBean> QueryNewBooks(String[] args);

	public BookInfoBean QueryNewBook(String[] args);

}