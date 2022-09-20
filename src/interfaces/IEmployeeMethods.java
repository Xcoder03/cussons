package interfaces;

import model.Employee;

public interface IEmployeeMethods {
    public  boolean registerEmployee(Employee emp);
    public String deleteEmployee(String email, String comfirm);
    public String updateEmployee(Employee emp);
    public  String viewEmployee(String email);

}
