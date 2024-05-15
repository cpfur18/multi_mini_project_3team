package member.model.dto;


import java.io.Serializable;

/*
 * ID               VARCHAR2(20)
 * PW               VARCHAR2(10)
 * USERNAME         VARCHAR2(20)
 * PHONE            VARCHAR2(15)
 * MASTER           CHAR
 */
public class Member implements Serializable {

    private static final long serialVersionUID = 2304690199893905221L;

    private String id;
    private String pw;
    private String userName;
    private String phone;
    private char master;          //y: 관리자 n:일반회원


    public Member() {
        // TODO Auto-generated constructor stub
    }

    //ID, PW
    public Member(String id, String pw) {
        super();
        this.id = id;
        this.pw = pw;
    }

    //ID, PW, USERNAME, PHONE, MASTER 'N'
    public Member(String id, String pw, String userName, String phone, char master) {
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

    public void setPw(String password) {
        this.pw = pw;
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


    //Master Get & Set
    public char getMaster() {
        return master;
    }

    public void setMaster(char master) {
        this.master = master;
    }

    public String toString() {
        return "아이디: " + id + " 비밀번호: " + pw + " 닉네임: " + userName + " 전화번호 " + phone + " 관리자 권한: " + master;
    }
}