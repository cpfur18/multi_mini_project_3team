package reservation.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static common.JDBCTemplate.close;

public class ResverationDao {
    public ResverationDao() {
        try {
            prop = new Properties();
            prop.load(new FileReader("resources/query.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Properties prop = null;
    public int insertResveration(Connection conn, String timeCode, String seatCode, int totalMoney, int memberNO) throws Exception{
        int result = 0;
        PreparedStatement ps = null;

        String sql = prop.getProperty("revInsert");

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, memberNO );
            ps.setString(2, seatCode );
            ps.setString(3, timeCode );
            ps.setInt(4, totalMoney );

            result = ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("insert 에러 : " + e.getMessage());

        }finally {
            close(ps);
        }

        return result;
    }
}
