package edu.college.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.college.bean.AdminBean;
import edu.college.bean.*;
import edu.college.impl.UserInterface;

public class UserDao extends BaseDao implements UserInterface {
	
 	@Override
	public int addUser(String[] args) {
		String sql = "insert into tb_user (Uname, Uage, UidCard, effectivedate, Utel, balance, UserId,starttime,Upsw) values (?,?,?,'"
				+ super.getAfterDate() + "',?,0,?,'" + super.getDate() + "',?)";
		return super.update(sql, args);
	}

 	@Override
	public int addArrearageUser(String[] args) {
		String sql = "insert into tb_blacklist (arrearageName, arrearageId, arrearageIdCard,arrearageBalance) values (?,?,?,?)";
		return super.update(sql, args);
	}
	

  	@Override
	public int updateUserInfo(String[] args) {
		String sql = "update tb_user set Uname=?,Utel=? where UserId=?";
		return super.update(sql, args);
	}

  	@Override
	public UserInfoBean getUser(String[] args) {
		String sql = "select Uname,Uage,UidCard,effectivedate,Utel,balance,startTime,Upsw from tb_user where UserId=?";
		ResultSet rs = super.select(sql, args);
		UserInfoBean uib = null;
		try {
			if (rs.next()) {
				String uname = rs.getString("Uname");
				String uage = String.valueOf(rs.getInt("Uage"));
				String uidCard = rs.getString("UidCard");
				String effectivedate = rs.getDate("effectivedate").toString();
				String utel = rs.getString("Utel");
				String balance = String.valueOf(rs.getFloat("balance"));
				String startTime = rs.getDate("startTime").toString();
				String upsw = rs.getString("Upsw");
				uib = new UserInfoBean(uname, uage, uidCard, effectivedate,
						utel, balance, args[0], startTime, upsw);
				return uib;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return uib;
		}
		return uib;
	}

 

	@Override
	public UserInfoBean checkLogin(String[] args) {
		String sql = "select Uname,Uage,UidCard,effectivedate,Utel,balance,starttime from tb_user where UserId=? and Upsw=?";
		ResultSet rs = super.select(sql, args);
		UserInfoBean uib = null;
		try {
			if (rs.next()) {
				String uname = rs.getString("Uname");
				String uage = String.valueOf(rs.getInt("Uage"));
				String uidCard = rs.getString("UidCard");
				String effectivedate = rs.getDate("effectivedate").toString();
				String utel = rs.getString("Utel");
				String balance = String.valueOf(rs.getFloat("balance"));
				String startTime = rs.getDate("startTime").toString();
				uib = new UserInfoBean(uname, uage, uidCard, effectivedate,
						utel, balance, args[0], startTime, args[1]);
				return uib;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return uib;
		}
		return uib;
	}


	@Override
	public AdminBean checkAdminLogin(String[] args) {
		String sql = "select Aname,Asex,Aage,AidCard,Atel,Alevel from tb_admin where Aid=? and Apsw=?";
		ResultSet rs = super.select(sql, args);
		AdminBean ab = null;
		try {
			if (rs.next()) {
				String Aname = rs.getString("Aname");
				String Asex = rs.getString("Asex");
				String Aage = rs.getString("Aage");
				String AidCard = rs.getString("AidCard");
				String Atel = rs.getString("Atel");
				String Alevel = rs.getString("Alevel");
				ab = new AdminBean(args[0], Aname, Asex, Aage, AidCard, Atel,
						Alevel, args[1]);
				return ab;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ab;
	}
   
 	@Override
	public int rechargeUser(String[] args) {
		String sql = "update tb_user set balance=balance+? where UserId=?";
		return super.update(sql, args);
	}
    
 	@Override
	public int updatePsw(String[] args) {
		String sql = "update tb_user set Upsw=? where UserId=?";
		return super.update(sql, args);
	}

 	@Override
	public List<UserInfoBean> getAllUser(String[] args) {
		String sql = "select Uname,Uage,UidCard,effectivedate,Utel,balance,UserId,startTime,Upsw from tb_user";
		ResultSet rs = super.select(sql, args);
		List<UserInfoBean> uib = new ArrayList<UserInfoBean>();
		try {
			while (rs.next()) {
				String uname = rs.getString("Uname");
				String uage = String.valueOf(rs.getInt("Uage"));
				String uidCard = rs.getString("UidCard");
				String effectivedate = rs.getDate("effectivedate").toString();
				String utel = rs.getString("Utel");
				String balance = String.valueOf(rs.getFloat("balance"));
				String startTime = rs.getDate("startTime").toString();
				String upsw = rs.getString("Upsw");
				String UserId = rs.getString("UserId");
				uib.add(new UserInfoBean(uname, uage, uidCard, effectivedate,
						utel, balance, UserId, startTime, upsw));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uib;
	}

 	@Override
	public BlackListBean getArrearageUser(String[] args) {
		String sql = "select arrearageName,arrearageIdCard,arrearageBalance from tb_blacklist where arrearageId=?";
		ResultSet rs = super.select(sql, args);
		BlackListBean uib = null;
		try {
			if (rs.next()) {
				String arrearageName = rs.getString("arrearageName");
				String arrearageIdCard = rs.getString("arrearageIdCard");
				String arrearageBalance = rs.getString("arrearageBalance");
				uib = new BlackListBean(arrearageName, args[0],
						arrearageIdCard, arrearageBalance);
				return uib;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return uib;
		}
		return uib;
	}

 	@Override
	public int deleteArrearageUser(String[] args) {
		String sql = "delete from tb_blacklist where arrearageId=?";
		return super.update(sql, args);
	}

 	public int rechargeArrearageUser(String[] args) {
		String sql = "update tb_blacklist set arrearageBalance=arrearageBalance+? where arrearageId=?";
		return super.update(sql, args);
	}

}