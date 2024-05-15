package member.model.dao;

import member.model.dto.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberDao {

    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "caf";
    String password = "caf";

    // 멤버 테이블의 컬럼명 정의
    private static final String MEMBER_NO_COLUMN = "MEMBER_NO";
    private static final String ID = "ID";
    private static final String PW = "PW";
    private static final String USERNAME = "USERNAME";
    private static final String PHONE = "PHONE";
    private static final String MASTER = "MASTER";

    // 데이터베이스 연결을 위한 메서드
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    //로그인
    public int loginAccount(Connection conn, Member member) {
        int result = 0;



        return result;
    }

    //회원가입
    public int createAccount(Connection conn, Member member) {

        int result = 0;



        return result;
    }

    //deleteMember() infoMember() updateMember()
    //회원 삭제

    //회원 정보 조회

    //회원 정보 수정

    //deleteAccount() infoAccount() updateAccount()
    //회원 탈퇴

    //회원 정보 조회

    //회원 정보 수정

}