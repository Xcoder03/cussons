package interfaces;

import model.Orders;

public interface IOrderMethods {
    public boolean placeBabyOrders(Orders order, int quantity, int price);
    public boolean placeHygieneOrders(Orders order);
    public boolean placeBeautyOrders(Orders order);
    public boolean cancelOrder(Orders order);
    public boolean viewAllorders(Orders order);
}
