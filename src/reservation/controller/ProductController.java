package reservation.controller;

import common.excption.Exception;
import reservation.model.dto.Product;
import reservation.service.ProductService;
import reservation.view.ProductMenu;
import reservation.view.ViewUtils;

import java.util.ArrayList;

public class ProductController {
    private ProductService productService = new ProductService();
    public ArrayList<Product> selectAll() {
        ArrayList<Product> p = null;
        ProductMenu menu = new ProductMenu();
        try {
            p = productService.selectAll();
            if (p != null) {

            }else{
                System.out.println("데이터없음" + p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("조회실패" + p);
        }
        return p;
    }

    public int selectTotalMoney(ArrayList<String> prdInputList) {
        ViewUtils viewUtils = new ViewUtils();
        Product p = null;
        int totalMoney = 0;
        try {
            p = productService.selectTotalMoney(prdInputList);
            if (p != null) {
                for (String productName : prdInputList) {
                    totalMoney += p.getPrice();
                }
            }else{
                viewUtils.printNoData();
            }
        } catch (Exception e) {
            e.printStackTrace();
            viewUtils.printQueryFailed();
        }
        return totalMoney;
    }
}
