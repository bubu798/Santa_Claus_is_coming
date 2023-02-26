package main;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Present {
    private String productName;
    private Double price;
    private String category;
    @JsonIgnore
    private Double quantity;

    public String getProductName() {
        return productName;
    }
    @JsonIgnore
    public Double getQuantity() {
        return quantity;
    }
    @JsonProperty
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public Present() {}

    public Present(Present other) {
        this.productName = other.getProductName();
        this.price = other.getPrice();
        this.category = other.getCategory();
        this.quantity = other.getQuantity();
    }

    @Override
    public String toString() {
        return "Present{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
