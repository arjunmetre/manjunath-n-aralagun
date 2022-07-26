package edu.college.impl;

import java.util.List;

import edu.college.bean.*;

public interface UserInterface {
	public int addUser(String[] args);

	//public int deleteUser(String[] args);

	public int updateUserInfo(String[] args);

	public UserInfoBean getUser(String[] args);

	public UserInfoBean checkLogin(String[] args);

	public int rechargeUser(String[] args);

	public int updatePsw(String[] args);

	public AdminBean checkAdminLogin(String[] args);

	public List<UserInfoBean> getAllUser(String[] args);

	public int addArrearageUser(String[] args);

	public BlackListBean getArrearageUser(String[] args);

	public int deleteArrearageUser(String[] args);
}