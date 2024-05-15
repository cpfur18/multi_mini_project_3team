package reservation.controller;

import reservation.model.dto.Product;
import reservation.service.ProductService;
import reservation.view.ProductMenu;

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
}
