package services;

import databaseConnection.CussonsConnection;
import interfaces.IOtherMethods;
import model.Employee;
import model.Orders;
import model.RawMaterials;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OtherProducts  implements IOtherMethods {
    PreparedStatement pr;
    ResultSet res;
    CussonsConnection con = new CussonsConnection();



    @Override
    public boolean uploadRawMaterials(RawMaterials rw) {
        return false;
    }

    @Override
    public boolean registerEmployee(Employee emp) {
        return false;
    }

    @Override
    public boolean order(Orders order) {
        return false;
    }
}
