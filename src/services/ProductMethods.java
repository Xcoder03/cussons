package services;

import databaseConnection.CussonsConnection;
import interfaces.IProductMethods;
import model.Produce;

import java.security.Permission;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductMethods implements IProductMethods {
    PreparedStatement pr;
    ResultSet res;
    CussonsConnection con = new CussonsConnection();
    ArrayList<String> beautyProducts = new ArrayList<>();
    ArrayList<String> babyProducts = new ArrayList<>();
    ArrayList<String> hygieneProducts = new ArrayList<>();




    @Override
    public boolean uploadBeautyProduct(Produce produce) {
        int upd ;
        String INSERT = "INSERT INTO beautyproducts (id, productName, quantity, productionDate, expirationDate, price) VALUES (?,?,?,?,?,?)";
         if (con.connectToDatebase()){
           try{
               pr = con.getConnections().prepareStatement(INSERT);
               pr.setString(1,produce.getId());
               pr.setString(2,produce.getProductName());
               pr.setInt(3,produce.getQuantity());
               pr.setString(4, produce.getProductionDate());
               pr.setString(5,produce.getExpirationDate());
               pr.setInt(6,produce.getPrice());
                   upd = pr.executeUpdate();
              if (upd== 0){
                  System.out.println(" >>> Product not inserted ");
                  return  false;
              }
              else{
                  System.out.println(" >>> Product inserted successfully");
              }

           }catch (SQLException e){
               e.printStackTrace();
           }
         }
        return true;
    }

    @Override
    public boolean uploadHygieneProduct(Produce produce) {
        int upd ;
        String INSERT = "INSERT INTO hygieneproducts (id, productName, quantity, productionDate, expirationDate, price) VALUES (?,?,?,?,?,?)";
        if (con.connectToDatebase()){
            try{
                pr = con.getConnections().prepareStatement(INSERT);
                pr.setString(1,produce.getId());
                pr.setString(2,produce.getProductName());
                pr.setInt(3,produce.getQuantity());
                pr.setString(4, produce.getProductionDate());
                pr.setString(5,produce.getExpirationDate());
                pr.setInt(6,produce.getPrice());
                upd = pr.executeUpdate();
                if (upd== 0){
                    System.out.println(" >>> Product not inserted ");
                    return  false;
                }
                else{
                    System.out.println(" >>> Product inserted successfully");
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;

    }

    @Override
    public boolean uploadBabyProduct(Produce produce) {


        int upd ;
        String INSERT = "INSERT INTO babyproducts (id, productName, quantity, productionDate, expirationDate, price) VALUES (?,?,?,?,?,?)";
        if (con.connectToDatebase()){
            try{
                pr = con.getConnections().prepareStatement(INSERT);
                pr.setString(1,produce.getId());
                pr.setString(2,produce.getProductName());
                pr.setInt(3,produce.getQuantity());
                pr.setString(4, produce.getProductionDate());
                pr.setString(5,produce.getExpirationDate());
                pr.setInt(6,produce.getPrice());
                upd = pr.executeUpdate();
                if (upd== 0){
                    System.out.println(" >>> Product not inserted ");
                    return  false;
                }
                else{
                    System.out.println(" >>> Product inserted successfully");
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;

    }

    @Override
    public String deleteProduct(String productName, String confirm) {
        String status = "";

        int upd = 0;
        if (beautyProducts.contains(productName)){
            String DELETEPRODUCT = " DELETE FROM beautyproducts WHERE productName = ? ";
            if (con.connectToDatebase()){
                try{
                    con.getConnections().prepareStatement(DELETEPRODUCT);
                    pr.setString(1, productName);
                    if(confirm.equalsIgnoreCase("y")){
                        upd = pr.executeUpdate();
                    } else {
                        System.out.println("  >>  Operation aborted");
                    }

                    if(upd == 0){
                        status = "  >>  Deletion not successful";
                        return status;
                    } else {
                        status= "  >>  Product deleted successfully";
                        ;
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        else if (babyProducts.contains(productName)){
            String DELETEPRODUCT = " DELETE FROM babyproducts WHERE productName = ? ";
            if (con.connectToDatebase()){
                try{
                    con.getConnections().prepareStatement(DELETEPRODUCT);
                    pr.setString(1, productName);
                    if(confirm.equalsIgnoreCase("y")){
                        upd = pr.executeUpdate();
                    } else {
                        System.out.println("  >>  Operation aborted");
                    }

                    if(upd == 0){
                        status = "  >>  Deletion not successful";
                        return status;
                    } else {
                        status= "  >>  Product deleted successfully";
                        ;
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        }


        else if (hygieneProducts.contains(productName)){
            String DELETEPRODUCT = " DELETE FROM hygieneproducts WHERE productName = ? ";
            if (con.connectToDatebase()){
                try{
                    con.getConnections().prepareStatement(DELETEPRODUCT);
                    pr.setString(1, productName);
                    if(confirm.equalsIgnoreCase("y")){
                        upd = pr.executeUpdate();
                    } else {
                        System.out.println("  >>  Operation aborted");
                    }

                    if(upd == 0){
                        status = "  >>  Deletion not successful";
                        return status;
                    } else {
                        status= "  >>  Product deleted successfully";
                        ;
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        }

        else
        {
            status = "Product not found";
        }

        return  status;
    }

    @Override
    public boolean viewProduct(String productName) {
        Produce pd = new Produce();

    }
}
