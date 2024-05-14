package com.multi.jdbc.member.model.dto;


import java.io.Serializable;
import java.sql.Date;

/*
 * ID               VARCHAR2(20)
 * PW               VARCHAR2(10)
 * USERNAME         VARCHAR2(20)
 * PHONE            VARCHAR2(15)
 * JOIN_DATE        DATE
 * MASTER           CHAR
 */
public class Member implements Serializable {

	private static final long serialVersionUID = 2304690199893905221L;

	private String id;
	private String pw;
	private String userName;
	private String phone;
	private Date joinDate;          //가입일
	private String master;          //y: 관리자 n:일반회원

	//생성자
	public Member() {
//		 TODO Auto-generated constructor stub
	}

	//가입일(joinDate) SYSDATE 처리하기 위해 매개변수로 받지 않음
	public Member(String id, String pw, String userName, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.phone = phone;
	}

	public Member(String id, String pw, String userName, String phone, String master) {
		super();
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.phone = phone;
		this.master = master;
	}

	//ID Get & Set
	public String getId() {
		return id;
	}

	public void setId(String userId) {
		this.id = id;
	}

	//PW Get & Set
	public String getPw() {
		return pw;
	}

	public void setPassword(String password) {
		this.pw = password;
	}

	//UserName Get & Set
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	//Phone Get & Set
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//JoinDate Get & Set
	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	//Master Get
	public String getMaster() {
		return master;
	}

	public String toString() {
		return "아이디: " + id + " 비밀번호: " + pw + " 닉네임: " + userName + " 전화번호 " + phone + " 가입일: " + joinDate + " 구분: " + master;
	}
}