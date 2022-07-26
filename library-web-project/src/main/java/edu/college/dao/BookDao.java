package edu.college.dao;

import edu.college.impl.BookInterface;

public class BookDao extends BaseDao implements BookInterface {

	@Override
	public int addKindsBooks(String[] args) {
		String sql = "insert into tb_booktype (btid, type, days) values (?,?,'" + super.getDay() + "')";
		return super.update(sql, args);
	}

	@Override
	public int updateKindsbooks(String[] args) {
		String sql = "update tb_booktype set type=? where btid=?";
		System.out.println(args[0] + "*******" + args[1]);
		return super.update(sql, args);
	}

	@Override
	public int addBooks(String[] args) {
		String sql = "insert into tb_bookinfo (ISBN, typeId, bookname, writer, translator, publisher, date, price) values (?,?,?,?,?,?,?,?)";
		return super.update(sql, args);
	}

	@Override
	public int deleteBooks(String[] args) {
		String sql = "delete from tb_bookinfo where ISBN=?";
		return super.update(sql, args);
	}

	@Override
	public int borrowBook(String[] args) {
		String sql1 = "insert into tb_borrowrecord (bookISBN, userISBN, borrowDate, backDate, isback) values (?,?,'"
				+ super.getDate() + "','" + super.getAfter30Date() + "',0)";
		String sql2 = "update tb_stockpile set amount=amount-1 where ISBN=?";
		int n = super.update(sql1, args);
		String arg[] = { args[0] };
		int m = super.update(sql2, arg);
		return n & m;
	}

	@Override
	public int backBook(String[] args) {
		System.out.println(super.getDate());
		String sql1 = "update tb_borrowrecord set isback=1,backDate='" + super.getDate()
				+ "' where bookISBN=? and userISBN=?";
		String sql2 = "update tb_stockpile set amount=amount+1 where ISBN=?";
		System.out.println(sql1);
		int n = super.update(sql1, args);
		String args2[] = { args[0] };
		int m = super.update(sql2, args2);
		return n & m;
	}

	@Override
	public int renewBook(String[] args) {
		System.out.println(super.getDate());
		String sql1 = "update tb_borrowrecord set backDate='" + super.getAfter30Date() + "',borrowDate='"
				+ super.getDate() + "' where bookISBN=? and userISBN=?";
		System.out.println(sql1);
		int n = super.update(sql1, args);
		return n;
	}

	@Override
	public int deleteNewBooks(String[] args) {
		String sql = "delete from tb_newbooks where newISBN=?";
		return super.update(sql, args);
	}

	@Override
	public int addNewStocks(String[] args) {
		String sql = "insert into tb_stockpile(ISBN,amount) values(?,5)";
		return super.update(sql, args);
	}

	@Override
	public int delNewStocks(String[] args) {
		String sql = "delete from tb_stockpile where ISBN=?";
		return super.update(sql, args);
	}

	 

}