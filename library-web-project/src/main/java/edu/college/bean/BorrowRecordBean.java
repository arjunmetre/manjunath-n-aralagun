
package edu.college.bean;


public class BorrowRecordBean {
	private String recordid;
	private String bookISBN;
	private String userISBN;
	private String isback;
	private String borrowDate;
	private String backDate;
	private String bookName;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public BorrowRecordBean() {
		super();
	}

	
	public BorrowRecordBean(String recordid, String bookISBN, String bookName,
			String userISBN, String isback, String borrowDate, String backDate) {
		super();
		this.recordid = recordid;
		this.bookISBN = bookISBN;
		this.bookName = bookName;
		this.userISBN = userISBN;
		this.isback = isback;
		this.borrowDate = borrowDate;
		this.backDate = backDate;
	}

	
	public String getRecordid() {
		return recordid;
	}

	
	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}

	
	public String getBookISBN() {
		return bookISBN;
	}

	
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	
	public String getUserISBN() {
		return userISBN;
	}

	
	public void setUserISBN(String userISBN) {
		this.userISBN = userISBN;
	}

	
	public String getIsback() {
		return isback;
	}

	
	public void setIsback(String isback) {
		this.isback = isback;
	}

	
	public String getBorrowDate() {
		return borrowDate;
	}

	
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	
	public String getBackDate() {
		return backDate;
	}

	
	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}
}