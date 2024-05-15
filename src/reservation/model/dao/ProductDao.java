package reservation.model.dao;

import common.excption.Exception;
import reservation.model.dto.Product;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static common.JDBCTemplate.close;

public class ProductDao {

    private Properties prop = null;
    public ProductDao() {
        try {
            prop = new Properties();
            prop.load(new FileReader("resources/query.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Product> selectAll(Connection conn) throws Exception {
        ArrayList<Product> list = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = prop.getProperty("prdSelectAll");
        try {
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            list = new ArrayList<Product>();

            while (rs.next()) {
                Product p = new Product();

                p.setProductNo(rs.getInt("PRODUCT_NO"));
                p.setName(rs.getString("NAME"));
                p.setPrice(rs.getInt("PRICE"));
                p.setCategoryName(rs.getString("C_NAME"));
                list.add(p);
            }

        } catch (SQLException e) {
            throw new Exception("selectAll 에러 : " + e.getMessage());
        } finally {
            close(rs);
            close(ps);
        }
        return list;
    }
}
