package services;

import databaseConnection.CussonsConnection;
import interfaces.IProductMethods;
import model.Produce;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMethods implements IProductMethods {
    PreparedStatement pr;
    ResultSet res;
    CussonsConnection con = new CussonsConnection();



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
}
