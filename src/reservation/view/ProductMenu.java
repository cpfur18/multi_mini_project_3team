package reservation.view;

import reservation.controller.ProductController;
import reservation.model.dto.Product;
import reservation.service.ProductService;

import java.util.ArrayList;
import java.util.Scanner;


public class ProductMenu {
    private static Scanner sc = new Scanner(System.in); // Scanner 객체 생성
    private ViewUtils viewUtils = new ViewUtils();

    private ProductController productController = new ProductController();
    private ProductService productService = new ProductService();

    int answer = 0;

    public void prdMainMenu() {
        do {
            System.out.println("========================================");
            prdListDisplay();
            System.out.println("========================================");
            System.out.print("구매하실 상품 이름 입력하세요 : ");
            do {
                do {
                    String answer = productService.insertType(productController.selectAll(), sc.next());
                    if(answer != null) break;
                } while (true);
                break;
            } while (true);



            System.out.println("결제 화면으로 이동합니다.");
            System.out.println();

        } while (true);
    }

    public void prdListDisplay() {
        ArrayList<Product> prdList = productController.selectAll();
        for (Product product : prdList) {
            System.out.println("[" + product.getCategoryName() + "]" + " " + product.getName() + " / " + product.getPrice() + "원");
        }

    }
}