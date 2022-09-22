package services;

import databaseConnection.CussonsConnection;
import interfaces.IOrderMethods;
import model.Employee;
import model.Orders;
import model.Produce;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMethods implements IOrderMethods {
    PreparedStatement pr;
    ResultSet res;
    CussonsConnection con = new CussonsConnection();
    int retailPrice;
    int retailQuantity;


    public  void quantityChecker(String productName){


      Produce pd = new Produce();
        if(con.connectToDatebase()){
            String quanityCheck = "SELECT price, quantity FROM babyproducts WHERE productName = ?";
            try{
                pr = con.getConnections().prepareStatement(quanityCheck);
                pr.setString(1, productName);
                res = pr.executeQuery();
                if(res.next()){
                    pd.setQuantity(res.getInt("quantity"));
                    pd.setPrice(res.getInt("price"));
                }
            } catch (SQLException e ){
                e.printStackTrace();
            }
        }

        retailQuantity = pd.getQuantity();
        retailPrice = pd.getPrice();


    }


    @Override
    public boolean placeBabyOrders(Orders order, int quantity, int price) {
        int upd;
        OrderMethods ord = new OrderMethods();
        int totalPrice = quantity * price;
        ord.quantityChecker(order.getProductname());
        if (retailQuantity >= quantity){
               if(con.connectToDatebase()){
                String babyOrder = "INSERT INTO babyorders(boID, productName, quantity, customerName, orderDate, deliveryDate, address, price) VALUES (?,?,?,?,?,?,?,?)";
                try{
                    pr = con.getConnections().prepareStatement(babyOrder);
                    pr.setString(1,order.getOrderID());
                    pr.setString(2,order.getProductname());
                    pr.setInt(3,order.getQuantity());
                    pr.setString(4,order.getCustomerName());
                    pr.setString(5,order.getOrderDate());
                    pr.setString(6,order.getDeliveryDate());
                    pr.setString(7,order.getAddress());
                    pr.setInt(8, totalPrice);
                    upd = pr.executeUpdate();
                    if (upd== 0){
                        System.out.println(" >>> order cancelled due to wrong input ");
                        return  false;
                    }
                    else{
                        System.out.println(" >>> order has been taken");
                    }

                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        }
        else
            System.out.println("not enough quantity remaining");




        return true;
    }

    @Override
    public boolean placeHygieneOrders(Orders order) {
        int upd;
        String babyOrder = "INSERT INTO hygieneorders(hyID, productName, quantity, customerName, orderDate, deliveryDate, address, price) VALUES (?,?,?,?,?,?,?,?)";
        if(con.connectToDatebase()){
            try{
                pr = con.getConnections().prepareStatement(babyOrder);
                pr.setString(1,order.getOrderID());
                pr.setString(2,order.getProductname());
                pr.setInt(3,order.getQuantity());
                pr.setString(4,order.getCustomerName());
                pr.setString(5,order.getOrderDate());
                pr.setString(6,order.getDeliveryDate());
                pr.setString(7,order.getAddress());
                upd = pr.executeUpdate();
                if (upd== 0){
                    System.out.println(" >>> order cancelled due to wrong input ");
                    return  false;
                }
                else{
                    System.out.println(" >>> order has been taken");
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public boolean placeBeautyOrders(Orders order) {
        int upd;
        String babyOrder = "INSERT INTO beautyorders(btyID, productName, quantity, customerName, orderDate, deliveryDate, address) VALUES (?,?,?,?,?,?,?)";
        if(con.connectToDatebase()){
            try{
                pr = con.getConnections().prepareStatement(babyOrder);
                pr.setString(1,order.getOrderID());
                pr.setString(2,order.getProductname());
                pr.setInt(3,order.getQuantity());
                pr.setString(4,order.getCustomerName());
                pr.setString(5,order.getOrderDate());
                pr.setString(6,order.getDeliveryDate());
                pr.setString(7,order.getAddress());
                upd = pr.executeUpdate();
                if (upd== 0){
                    System.out.println(" >>> order cancelled due to wrong input ");
                    return  false;
                }
                else{
                    System.out.println(" >>> order has been taken");
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public boolean cancelOrder(Orders order) {
        return false;
    }

    @Override
    public boolean viewAllorders(Orders order) {
        return false;
    }
}
