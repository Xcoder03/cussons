package interfaces;

import model.Employee;
import model.Orders;
import model.RawMaterials;

public interface IOtherMethods {
    public boolean uploadRawMaterials(RawMaterials rw);
    public boolean babyOrders(Orders order);
    public boolean hygieneOrders(Orders order);
    public boolean beautyOrders(Orders order);

}
