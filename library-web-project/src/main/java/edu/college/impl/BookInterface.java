package edu.college.impl;

public interface BookInterface {
	public int addKindsBooks(String[] args);

	public int updateKindsbooks(String[] args);

	// public int deleteKindsbooks(String[] args);

	public int addBooks(String[] args);

	public int deleteBooks(String[] args);

	public int borrowBook(String[] args);

	public int backBook(String[] args);

	public int renewBook(String[] args);

	public int deleteNewBooks(String[] args);

	public int addNewStocks(String[] args);

	public int delNewStocks(String[] args);

}