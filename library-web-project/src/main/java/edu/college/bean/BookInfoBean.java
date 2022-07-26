
package edu.college.bean;


public class BookInfoBean {
	
	private String ISBN;
	
	private String typeId;
	
	private String bookname;
	
	private String writer;
	
	private String translator;
	
	private String publisher;
	
	private String date;
	
	private String price;

	
	public BookInfoBean() {
		super();
	}

	
	public BookInfoBean(String ISBN, String typeId, String bookname,
			String writer, String translator, String publisher, String date,
			String price) {
		super();
		this.ISBN = ISBN;
		this.typeId = typeId;
		this.bookname = bookname;
		this.writer = writer;
		this.translator = translator;
		this.publisher = publisher;
		this.date = date;
		this.price = price;
	}

	
	public String getISBN() {
		return ISBN;
	}

	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	
	public String getTypeId() {
		return typeId;
	}

	
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	
	public String getBookname() {
		return bookname;
	}

	
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	
	public String getWriter() {
		return writer;
	}

	
	public void setWriter(String writer) {
		this.writer = writer;
	}

	
	public String getTranslator() {
		return translator;
	}

	
	public void setTranslator(String translator) {
		this.translator = translator;
	}

	
	public String getPublisher() {
		return publisher;
	}

	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	
	public String getDate() {
		return date;
	}

	
	public void setDate(String date) {
		this.date = date;
	}

	
	public String getPrice() {
		return price;
	}

	
	public void setPrice(String price) {
		this.price = price;
	}
}