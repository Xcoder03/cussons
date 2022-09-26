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

   public  void actualChecker(String check, String name){

       Produce pd = new Produce();
       if(con.connectToDatebase()){

           try{
               pr = con.getConnections().prepareStatement(check);
               pr.setString(1, name);
               res = pr.executeQuery();
               if(res.next()){
                   pd.setPrice(res.getInt("price"));
                   pd.setQuantity(res.getInt("quantity"));

               }
           } catch (SQLException e ){
               e.printStackTrace();
           }
       }

       retailQuantity = pd.getQuantity();
       retailPrice = pd.getPrice();

   }
    public  void quantityChecker(String productName){
        ProductMethods prm = new ProductMethods();
        OrderMethods orm = new OrderMethods();
        if (prm.babyProducts.contains(productName)){
            String quanityCheck = "SELECT price, quantity FROM babyproducts WHERE productName = ?";
            orm.actualChecker(quanityCheck, productName);
        }

        else if (prm.beautyProducts.contains(productName)){
            String quanityCheck = "SELECT price, quantity FROM beautyproducts WHERE productName = ?";
            orm.actualChecker(quanityCheck, productName);
        }

        else if (prm.hygieneProducts.contains(productName)){
            String quanityCheck = "SELECT price, quantity FROM hygieneproducts WHERE productName = ?";
            orm.actualChecker(quanityCheck, productName);
        }
    }

    public  void quantityUpdateChecker(String productName, int quantity){
        ProductMethods prm = new ProductMethods();
        OrderMethods orm = new OrderMethods();
        if (prm.babyProducts.contains(productName)){
            String updateCheck = "UPDATE babyproduct SET quantity =? where productName = name ";
           String seacrhCheck  = "SELECT * FROM babyproduct WHERE productName = ?";
           orm.quantityUpdate(quantity,productName,updateCheck,seacrhCheck);
        }

        else if (prm.beautyProducts.contains(productName)){
            String updateCheck = "UPDATE beautyproduct SET quantity =? where productName = name ";
            String seacrhCheck  = "SELECT * FROM beautyproduct WHERE productName = ?";
            orm.quantityUpdate(quantity,productName,updateCheck,seacrhCheck);
        }

        else if (prm.hygieneProducts.contains(productName)){
            String updateCheck = "UPDATE hygieneproducts SET quantity =? where productName = name ";
            String seacrhCheck  = "SELECT * FROM hygieneproducts WHERE productName = ?";
            orm.quantityUpdate(quantity,productName,updateCheck,seacrhCheck);
        }
    }


    public String quantityUpdate(int quantity, String name, String update, String search){
        PreparedStatement ps;

        String status = "";

     if(con.connectToDatebase()){
      try{
          pr = con.getConnections().prepareStatement(search);
          pr.setString(1 ,name);
          res = pr.executeQuery();

          if(res.next()){
              ps = con.getConnections().prepareStatement(update);
              ps.setInt(1,quantity);
              ps.setString(2,name);


              int upd = ps.executeUpdate();
              if(upd == 0){
                  status = "  >>  Update failed";
                  return status;
              } else {
                  status = "  >>  Update completed";
              }
          } else{
              status = "  >>  Record not found";
          }
      }catch (SQLException e){
          e.printStackTrace();
        }
     }
  return  status;

    }


    @Override
    public boolean placeBabyOrders(Orders order, int quantity, int price) {
        int upd;
        OrderMethods ord = new OrderMethods();
        int totalPrice = quantity * price;
        int newQuantity;
        ord.quantityChecker(order.getProductname());
        if (retailQuantity >= quantity){
            newQuantity = retailQuantity - quantity;
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

               ord.quantityUpdateChecker(order.getProductname(), newQuantity);

        }
        else
            System.out.println("not enough quantity remaining");




        return true;
    }

    @Override
    public boolean placeHygieneOrders(Orders order, int quantity, int price) {
        int upd;

        OrderMethods ord = new OrderMethods();
        int totalPrice = quantity * price;
        int newQuantity;
        ord.quantityChecker(order.getProductname());
        String babyOrder = "INSERT INTO hygieneorders(hyID, productName, quantity, customerName, orderDate, deliveryDate, address, price) VALUES (?,?,?,?,?,?,?,?)";
        if (retailQuantity >= quantity) {

        newQuantity = retailQuantity - quantity;


        if (con.connectToDatebase()) {
            try {
                pr = con.getConnections().prepareStatement(babyOrder);
                pr.setString(1, order.getOrderID());
                pr.setString(2, order.getProductname());
                pr.setInt(3, order.getQuantity());
                pr.setString(4, order.getCustomerName());
                pr.setString(5, order.getOrderDate());
                pr.setString(6, order.getDeliveryDate());
                pr.setString(7, order.getAddress());
                upd = pr.executeUpdate();
                if (upd == 0) {
                    System.out.println(" >>> order cancelled due to wrong input ");
                    return false;
                } else {
                    System.out.println(" >>> order has been taken");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            ord.quantityUpdateChecker(order.getProductname(), newQuantity);
    }
        else
            System.out.println("not enough quantity remaining");


        return true;
    }

    @Override
    public boolean placeBeautyOrders(Orders order, int quantity, int price) {
        int upd;
        OrderMethods ord = new OrderMethods();
        int totalPrice = quantity * price;
        int newQuantity;
        ord.quantityChecker(order.getProductname());
        String babyOrder = "INSERT INTO beautyorders(btyID, productName, quantity, customerName, orderDate, deliveryDate, address) VALUES (?,?,?,?,?,?,?)";
        if (retailQuantity >= quantity) {
            newQuantity = retailQuantity - quantity;
        if (con.connectToDatebase()) {
            try {
                pr = con.getConnections().prepareStatement(babyOrder);
                pr.setString(1, order.getOrderID());
                pr.setString(2, order.getProductname());
                pr.setInt(3, order.getQuantity());
                pr.setString(4, order.getCustomerName());
                pr.setString(5, order.getOrderDate());
                pr.setString(6, order.getDeliveryDate());
                pr.setString(7, order.getAddress());
                upd = pr.executeUpdate();
                if (upd == 0) {
                    System.out.println(" >>> order cancelled due to wrong input ");
                    return false;
                } else {
                    System.out.println(" >>> order has been taken");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            ord.quantityUpdateChecker(order.getProductname(), newQuantity);
    }
        else
            System.out.println("not enough quantity remaining");

        return true;
    }

    @Override
    public String cancelBabyOrder(String id , String confirm) {

        String status = "";

        int upd = 0;
        String DELETE_ORDER = "DELETE FROM babyorders WHERE boID = ?";
        if(con.connectToDatebase()){
            try{
                pr = con.getConnections().prepareStatement(DELETE_ORDER);
                pr.setString(1,id);
                if(confirm.equalsIgnoreCase("y")){
                    upd = pr.executeUpdate();
                } else {
                    System.out.println("  >>  Operation aborted");
                }

                if(upd == 0){
                    status = "  >>  Deletion not successful";

                } else {
                    status= "  >>  Order deleted successfully";

                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public String cancelBeautyOrder(String id, String confirm) {
        String status = "";

        int upd = 0;
        String DELETE_ORDER = "DELETE FROM beautyorders WHERE btyID = ?";
        if(con.connectToDatebase()){
            try{
                pr = con.getConnections().prepareStatement(DELETE_ORDER);
                pr.setString(1,id);
                if(confirm.equalsIgnoreCase("y")){
                    upd = pr.executeUpdate();
                } else {
                    System.out.println("  >>  Operation aborted");
                }

                if(upd == 0){
                    status = "  >>  Deletion not successful";

                } else {
                    status= "  >>  Order cancelled  successfully";

                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public String cancelHygieneOrder(String id, String confirm) {
        String status = "";

        int upd = 0;
        String DELETE_ORDER = "DELETE FROM hygieneorders WHERE hyID = ?";
        if(con.connectToDatebase()){
            try{
                pr = con.getConnections().prepareStatement(DELETE_ORDER);
                pr.setString(1,id);
                if(confirm.equalsIgnoreCase("y")){
                    upd = pr.executeUpdate();
                } else {
                    System.out.println("  >>  Operation aborted");
                }

                if(upd == 0){
                    status = "  >>  Deletion not successful";

                } else {
                    status= "  >>  Order cancel successfully";

                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public String viewBabyorders() {
        Orders ord = new Orders();

        if(con.connectToDatebase()){
            String DISPLAY_ALL = "SELECT * FROM babyorders";
            try{
                pr = con.getConnections().prepareStatement(DISPLAY_ALL);
                res = pr.executeQuery();
                if(res.next()){
                    ord.setOrderID(res.getString("boID"));
                    ord.setProductname(res.getString("productName"));
                    ord.setQuantity(res.getInt("quantity"));
                    ord.setCustomerName(res.getString("customerName"));
                    ord.setOrderDate(res.getString("orderDate"));
                    ord.setDeliveryDate(res.getString("deliveryDate"));
                    ord.setAddress(res.getString("address"));
                }
            } catch (SQLException e ){
                e.printStackTrace();
            }
        }

        return ord.toString();

    }


    @Override
    public String viewBeautyorders() {

        Orders ord = new Orders();

        if(con.connectToDatebase()){
            String DISPLAY_ALL = "SELECT * FROM beautyorders";
            try{
                pr = con.getConnections().prepareStatement(DISPLAY_ALL);
                res = pr.executeQuery();
                if(res.next()){
                    ord.setOrderID(res.getString("btyID"));
                    ord.setProductname(res.getString("productName"));
                    ord.setQuantity(res.getInt("quantity"));
                    ord.setCustomerName(res.getString("customerName"));
                    ord.setOrderDate(res.getString("orderDate"));
                    ord.setDeliveryDate(res.getString("deliveryDate"));
                    ord.setAddress(res.getString("address"));
                }
            } catch (SQLException e ){
                e.printStackTrace();
            }
        }

        return ord.toString();

    }


    @Override
    public String viewHygieneorders() {

        Orders ord = new Orders();

        if(con.connectToDatebase()){
            String DISPLAY_ALL = "SELECT * FROM hygieneorders";
            try{
                pr = con.getConnections().prepareStatement(DISPLAY_ALL);
                res = pr.executeQuery();
                if(res.next()){
                    ord.setOrderID(res.getString("hyID"));
                    ord.setProductname(res.getString("productName"));
                    ord.setQuantity(res.getInt("quantity"));
                    ord.setCustomerName(res.getString("customerName"));
                    ord.setOrderDate(res.getString("orderDate"));
                    ord.setDeliveryDate(res.getString("deliveryDate"));
                    ord.setAddress(res.getString("address"));
                }
            } catch (SQLException e ){
                e.printStackTrace();
            }
        }

        return ord.toString();


    }
}
