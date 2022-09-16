package services;

import databaseConnection.CussonsConnection;
import interfaces.IOtherMethods;
import model.Employee;
import model.Orders;
import model.RawMaterials;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OtherProducts  implements IOtherMethods {
    PreparedStatement pr;
    ResultSet res;
    CussonsConnection con = new CussonsConnection();



    @Override
    public boolean uploadRawMaterials(RawMaterials rw) {
        int upd;
        String INSERT = "INSERT INTO rawmaterials (rmID, name, quantity) VALUES (?,?,?)";
        if(con.connectToDatebase()){
            try{
                pr = con.getConnections().prepareStatement(INSERT);
                pr.setInt(1,rw.getId());
                pr.setString(2,rw.getName());
                pr.setInt(3,rw.getQuantity());
                upd = pr.executeUpdate();
                if (upd== 0){
                    System.out.println(" >>> raw materials not inserted ");
                    return  false;
                }
                else{
                    System.out.println(" >>> raw materials inserted successfully");
                }

            }catch (SQLException e){
                e.printStackTrace();
            }


        }


        return true;
    }

    @Override
    public boolean registerEmployee(Employee emp) {
        int upd;
        String INSERT = "INSERT INTO employees ( firstName, lastName, dob, email, address,department, employmentDate) VALUES (?,?,?,?,?,?,?)";
        if(con.connectToDatebase()){
            try{
              pr = con.getConnections().prepareStatement(INSERT);
              pr.setString(1,emp.getFirstname());
              pr.setString(2,emp.getLastname());
              pr.setString(3,emp.getDOB());
              pr.setString(4, emp.getEmail());
              pr.setString(5,emp.getAddress());
              pr.setString(6,emp.getDepartment());
              pr.setString(7,emp.getEmploymentDate());

                upd = pr.executeUpdate();
                if (upd== 0){
                    System.out.println(" >>> employee not inserted ");
                    return  false;
                }
                else{
                    System.out.println(" >>> employee inserted successfully");
                }


            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean hygieneOrders(Orders order) {
        int upd;
        String babyOrder = "INSERT INTO hygieneorders(hyID, productName, quantity, customerName, orderDate, deliveryDate, address) VALUES (?,?,?,?,?,?,?)";
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
    public boolean beautyOrders(Orders order) {
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
    public boolean babyOrders(Orders order) {
        int upd;
      String babyOrder = "INSERT INTO babyorders(boID, productName, quantity, customerName, orderDate, deliveryDate, address) VALUES (?,?,?,?,?,?,?)";
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
}
