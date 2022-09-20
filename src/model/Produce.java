package model;

public class Produce {
  String id;
  String productName;
  int quantity;
  String productionDate;
  String ExpirationDate;
  int price;

    public Produce() {
    }

    @Override
    public String toString() {
        return "Produce{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", productionDate='" + productionDate + '\'' +
                ", ExpirationDate='" + ExpirationDate + '\'' +
                ", price=" + price +
                '}';
    }

    public Produce(String id, String productName, int quantity, String productionDate, String expirationDate, int price) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.productionDate = productionDate;
        ExpirationDate = expirationDate;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        ExpirationDate = expirationDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
