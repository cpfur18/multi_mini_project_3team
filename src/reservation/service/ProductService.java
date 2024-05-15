package reservation.service;

import reservation.model.dao.ProductDao;
import reservation.model.dto.Product;
import reservation.view.ViewUtils;

import java.sql.Connection;
import java.util.ArrayList;

import static common.JDBCTemplate.getConnection;

public class ProductService {
    private ViewUtils viewUtils = new ViewUtils();
    public ProductService() {
        productDao = new ProductDao();
    }
    private final ProductDao productDao;
    public ArrayList<Product> selectAll() throws Exception {
        Connection conn = getConnection();
        ArrayList<Product> list = productDao.selectAll(conn);
        return list;
    }

    public String insertType(ArrayList<Product> products, String answer) {
        for (Product product : products) {
            if (product.getName().equals(answer)) {
                return answer;
            } else {
                viewUtils.printErrorMessage();
                answer = null;
                break;
            }
        }
        return answer;
    }
}
