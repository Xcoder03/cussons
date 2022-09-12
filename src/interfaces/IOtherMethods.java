package interfaces;

import model.Employee;
import model.Orders;
import model.RawMaterials;

public interface IOtherMethods {
    public boolean uploadRawMaterials(RawMaterials rw);
    public  boolean registerEmployee(Employee emp);
    public boolean order(Orders order);
}
