package tmate;

import java.sql.*;
import java.util.Scanner;

public class ProductManager {
    private Connection connect() {

        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "caf";
        String password = "caf";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException e) {
            System.out.println("연결 실패: " + e.getMessage());
        }
        return conn;
    }

    // 상품 추가 메소드
    private void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("상품 이름: ");
        String name = scanner.nextLine();
        System.out.print("가격: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("카테고리 코드: ");
        String categoryCode = scanner.nextLine();

        String sql = "INSERT INTO Product (PRODUCT_NO, NAME, PRICE, CATEGORYCODE) VALUES (SEQ_PRD_NO.NEXTVAL, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setString(3, categoryCode);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("상품이 성공적으로 추가되었습니다.");
            }
        } catch (SQLException e) {
            System.out.println("상품 추가 중 오류 발생: " + e.getMessage());
        }
    }


    // 상품 조회 메소드
    private void listProducts() {
        String sql = "SELECT * FROM Product";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("PRODUCT_NO") + " | " +
                        rs.getString("NAME") + " | " +
                        rs.getDouble("PRICE") + " | " +
                        rs.getString("CATEGORYCODE"));
            }
        } catch (SQLException e) {
            System.out.println("상품 목록 조회 중 오류 발생: " + e.getMessage());
        }
    }

    // 상품 수정 메소드
    private void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수정할 상품 번호: ");
        int productNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("새 상품 이름: ");
        String name = scanner.nextLine();
        System.out.print("새 가격: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("새 카테고리 코드: ");
        String categoryCode = scanner.nextLine();

        String sql = "UPDATE Product SET NAME = ?, PRICE = ?, CATEGORYCODE = ? WHERE PRODUCT_NO = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setString(3, categoryCode);
            pstmt.setInt(4, productNo);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("상품이 성공적으로 수정되었습니다.");
            }
        } catch (SQLException e) {
            System.out.println("상품 수정 중 오류 발생: " + e.getMessage());
        }
    }

    // 상품 삭제 메소드
    private void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제할 상품 번호: ");
        int productNo = scanner.nextInt();

        String sql = "DELETE FROM Product WHERE PRODUCT_NO = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productNo);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("상품이 성공적으로 삭제되었습니다.");
            }
        } catch (SQLException e) {
            System.out.println("상품 삭제 중 오류 발생: " + e.getMessage());
        }
    }

    // 메뉴 디스플레이 메소드
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n[상품 관리 시스템]");
            System.out.println("1. 상품 추가");
            System.out.println("2. 상품 조회");
            System.out.println("3. 상품 수정");
            System.out.println("4. 상품 삭제");
            System.out.println("0. 메뉴로 돌아가기");
            System.out.print("메뉴 선택: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.displayMenu();
    }
}
