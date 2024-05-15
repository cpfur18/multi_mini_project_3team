package reservation.model.dto;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 123456789L;

    private int productNo;
    private String name;
    private int price;
    private String categoryCode;
    private String categoryName;

    public Product() {}

    public Product(int productNo, String name, int price, String categorycode, String categoryname) {
        this.productNo = productNo;
        this.name = name;
        this.price = price;
        this.categoryCode = categorycode;
        this.categoryName = categoryname;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNo='" + productNo + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryCode='" + categoryCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
