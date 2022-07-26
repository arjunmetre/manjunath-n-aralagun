
package edu.college.bean;


public class AdminBean {
	private String aid;
	private String aname;
	private String asex;
	private String aage;
	private String aidCard;
	private String atel;
	private String alevel;
	private String apsw;

	public AdminBean() {
		super();
	}

	
	public AdminBean(String aid, String aname, String asex, String aage,
			String aidCard, String atel, String alevel, String apsw) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.asex = asex;
		this.aage = aage;
		this.aidCard = aidCard;
		this.atel = atel;
		this.alevel = alevel;
		this.apsw = apsw;
	}

	
	public String getAid() {
		return aid;
	}

	
	public void setAid(String aid) {
		this.aid = aid;
	}

	
	public String getAname() {
		return aname;
	}

	
	public void setAname(String aname) {
		this.aname = aname;
	}

	
	public String getAsex() {
		return asex;
	}

	
	public void setAsex(String asex) {
		this.asex = asex;
	}

	
	public String getAage() {
		return aage;
	}

	
	public void setAage(String aage) {
		this.aage = aage;
	}

	
	public String getAidCard() {
		return aidCard;
	}

	
	public void setAidCard(String aidCard) {
		this.aidCard = aidCard;
	}

	
	public String getAtel() {
		return atel;
	}

	
	public void setAtel(String atel) {
		this.atel = atel;
	}

	
	public String getAlevel() {
		return alevel;
	}

	
	public void setAlevel(String alevel) {
		this.alevel = alevel;
	}

	
	public String getApsw() {
		return apsw;
	}

	
	public void setApsw(String apsw) {
		this.apsw = apsw;
	}
}