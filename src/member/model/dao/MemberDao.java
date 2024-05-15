package member.model.dao;

import member.model.dto.Member;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MemberDao {

    private Properties prop = null;


    public MemberDao() {


        try {
            prop = new Properties();
            prop.load(new FileReader("resources/query.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public int loginAccount(Connection conn, Member member) {
        int result = 0;

        PreparedStatement ps = null;

        String sql = prop.getProperty("loginAccount"); //로그인


        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, member.getId());
            ps.setString(2, member.getPw());

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            close(ps);
        }

        return result;
    }

    public int insertMember(Connection conn, Member member) {

        int result = 0;

        PreparedStatement ps = null;

        String sql = prop.getProperty("insertMember"); ////회원 가입

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, member.getId());
            ps.setString(2, member.getPw());
            ps.setString(3, member.getUserName());
            ps.setString(4, member.getPhone());

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            close(ps);
        }

        return result;
    }


    public int updateMember(Connection conn, Member member) {

        int result = 0;

        PreparedStatement ps = null;

        String sql = prop.getProperty("updateMember"); //회원 정보 수정

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, member.getPw());
            ps.setString(2, member.getPhone());
            ps.setString(3, member.getUserName());
            ps.setString(4, member.getId());


            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            close(ps);
        }

        return result;
    }

    public int deleteMember(Connection conn, String memberId) {
        int result = 0;

        PreparedStatement ps = null;

        String sql = prop.getProperty("deleteMember"); //회원 삭제

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, memberId);

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            close(ps);
        }

        return result;
    }
}