package interfaces;

import model.Orders;

public interface IOrderMethods {
    public boolean placeBabyOrders(Orders order, int quantity, int price);
    public boolean placeHygieneOrders(Orders order, int quantity, int price);
    public boolean placeBeautyOrders(Orders order, int quantity, int price);
    public String cancelBabyOrder(String id , String confirm);
    public String cancelBeautyOrder(String id , String confirm);
    public String cancelHygieneOrder(String id, String confirm);
    public String viewBabyorders();

    public String viewBeautyorders();

    public String viewHygieneorders();
}
