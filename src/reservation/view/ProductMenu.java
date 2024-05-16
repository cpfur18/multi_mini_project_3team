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

    public void prdMainMenu(String timeCode, String serviceList, String seatCode, int memberNO) {
        ArrayList<String> prdInputList = new ArrayList<>();

        do {
            System.out.println("========================================");
            prdListDisplay();
            System.out.println("========================================");
            do {
                while (true) {
                        System.out.print("구매하실 상품 이름 입력하세요 : ");
                        String input = prdInput();
                        if (input != null) {
                            if (prdInputList.contains(input)) {
                                prdInputList.remove(input);
                                System.out.println("입력하신 상품이 삭제되었습니다.");
                            } else {
                                prdInputList.add(input);
                                System.out.println("입력 되었습니다.");
                            }
                            System.out.println(prdInputList);
                            break;
                    }
                }
                do {
                    System.out.println("더 입력하시겠습니까? YES(1)/No(0)");
                    int answer2 = sc.nextInt();
                    switch (answer2) {
                        case 0:
                            System.out.println("결제 화면으로 이동합니다.");
                            new PayMenu().payMenu(timeCode, serviceList, seatCode, prdInputList, memberNO);
                            break;
                        case 1:
                            break;
                        default:
                            viewUtils.printErrorMessage();
                    }
                    break;
                } while (true);
            } while (true);
        } while (true);
    }

    public void prdListDisplay() {
        ArrayList<Product> prdList = productController.selectAll();
        for (Product product : prdList) {
            System.out.println("[" + product.getCategoryName() + "]" + " " + product.getName() + " / " + product.getPrice() + "원");
        }
    }

    public String prdInput() {
        return productService.insertType(productController.selectAll(), sc.next());
    }
}