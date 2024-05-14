package member.model.dto;


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


	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public Member(String id, String pw, String userName, String phone, Date joinDate) {
		super();
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.phone = phone;
		this.joinDate = joinDate;
	}

	public Member(String id, String pw, String userName, String phone, Date joinDate, String master) {
		super();
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.phone = phone;
		this.joinDate = joinDate;
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

	//Master Get & Set
	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String toString() {
		return "아이디: " + id + " 비밀번호: " + pw + " 닉네임: " + userName + " 전화번호 " + phone + " 가입일: " + joinDate + " 구분: " + master;
	}
}