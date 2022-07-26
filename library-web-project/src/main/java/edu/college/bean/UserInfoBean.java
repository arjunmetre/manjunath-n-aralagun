package edu.college.bean;


public class UserInfoBean {
	private String uname;
	private String uage;
	private String uidCard;
	private String effectivedate;
	private String utel;
	private String balance;
	private String userId;
	private String startTime;
	private String upsw;

	public UserInfoBean() {
		super();
	}

	
	public UserInfoBean(String uname, String uage, String uidCard,
			String effectivedate, String utel, String balance, String userId,
			String startTime, String upsw) {
		super();
		this.uname = uname;
		this.uage = uage;
		this.uidCard = uidCard;
		this.effectivedate = effectivedate;
		this.utel = utel;
		this.balance = balance;
		this.userId = userId;
		this.startTime = startTime;
		this.upsw = upsw;
	}

	
	public String getUname() {
		return uname;
	}

	
	public void setUname(String uname) {
		this.uname = uname;
	}

	
	public String getUage() {
		return uage;
	}

	
	public void setUage(String uage) {
		this.uage = uage;
	}

	
	public String getUidCard() {
		return uidCard;
	}

	
	public void setUidCard(String uidCard) {
		this.uidCard = uidCard;
	}

	
	public String getEffectivedate() {
		return effectivedate;
	}

	
	public void setEffectivedate(String effectivedate) {
		this.effectivedate = effectivedate;
	}

	
	public String getUtel() {
		return utel;
	}

	
	public void setUtel(String utel) {
		this.utel = utel;
	}

	
	public String getBalance() {
		return balance;
	}

	
	public void setBalance(String balance) {
		this.balance = balance;
	}

	
	public String getUserId() {
		return userId;
	}

	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public String getStartTime() {
		return startTime;
	}

	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	
	public String getUpsw() {
		return upsw;
	}

	
	public void setUpsw(String upsw) {
		this.upsw = upsw;
	}
}