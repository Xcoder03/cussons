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






}
