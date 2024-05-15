package reservation.service;

import common.excption.Exception;
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
        boolean result = false;
        for (Product product : products) {
            if (product.getName().equals(answer)) {
                result = true;
                break;
            }
        }
        if (!result) {
            viewUtils.printErrorMessage();
            answer = null;
        }
        return answer;
    }

    public Product selectTotalMoney(ArrayList<String> prdInputList) throws Exception {
        Connection conn = getConnection();
        Product p = productDao.selectTotalMoney(conn, prdInputList);

        return p;
    }
}
