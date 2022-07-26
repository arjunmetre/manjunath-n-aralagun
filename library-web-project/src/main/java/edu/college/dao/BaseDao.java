package edu.college.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class BaseDao {
	private String driver = "";
	private String url = "";
	private String user = "";
	private String password = "";
	private static int time = 2;
	private static int day = 30;

	public BaseDao() {
		driver = PropertiesUtil.get("driver");
		url = PropertiesUtil.get("url");
		user = PropertiesUtil.get("user");
		password = PropertiesUtil.get("password");
	}

	public final Connection getConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public int update(String sql, String[] args) {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			 System.out.println(args[0]+"**&&&**"+args[1]);
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) { 
					pstmt.setString(i + 1, args[i]);
				}
			}
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public ResultSet select(String sql, String[] args) {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {  
					pstmt.setString(i + 1, args[i]);
				}
			}
			ResultSet result = pstmt.executeQuery();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().trim();
	}

	public String getAfterDate() {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		gc.setTime(new Date());
		gc.add(1, time);
		return sf.format(gc.getTime());
	}

	public String getAfter30Date() {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		gc.setTime(new Date());
		gc.add(5, day);
		return sf.format(gc.getTime());
	}

	public static int getDay() {
		return day;
	}

	public static void setDay(int day) {
		BaseDao.day = day;
	}
}