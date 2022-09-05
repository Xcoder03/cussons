package model;

public class Orders {
    int orderID;
    int quantity;
    String productname;
    String customerName;
    String orderDate;
    String deliveryDate;
    String address;

    public Orders() {
    }

    public Orders(int orderID, int quantity, String productname, String customerName, String orderDate, String deliveryDate, String address) {
        this.orderID = orderID;
        this.quantity = quantity;
        this.productname = productname;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.address = address;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
