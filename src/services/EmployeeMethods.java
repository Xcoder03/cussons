package services;

import databaseConnection.CussonsConnection;
import interfaces.IEmployeeMethods;
import model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMethods implements IEmployeeMethods {

    PreparedStatement pr;
    ResultSet res;
    CussonsConnection con = new CussonsConnection();




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
    public String deleteEmployee(String email, String confirm) {
        String status = "";

        int upd = 0;
        String DELETE_EMPLOYEE = "DELETE FROM employees WHERE email = ?";
        if(con.connectToDatebase()){
            try{
                pr = con.getConnections().prepareStatement(DELETE_EMPLOYEE);
                pr.setString(1,email);
                if(confirm.equalsIgnoreCase("y")){
                    upd = pr.executeUpdate();
                } else {
                    System.out.println("  >>  Operation aborted");
                }

                if(upd == 0){
                    status = "  >>  Deletion not successful";
                    return status;
                } else {
                    status= "  >>  Student deleted successfully";

                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public String updateEmployee(Employee emp) {
        PreparedStatement ps;

        String UPDATE =  "UPDATE employees SET firstName =?, lastName = ? WHERE email = ?";
        String SEARCH = "SELECT * FROM employees WHERE email = ?";
        String status = "";

        if (con.connectToDatebase()){
            try{
                pr = con.getConnections().prepareStatement(SEARCH);
                pr.setString(1 ,emp.getEmail());
                res = pr.executeQuery();
                if(res.next()){
                    ps = con.getConnections().prepareStatement(UPDATE);
                    ps.setString(1, emp.getFirstname());
                    ps.setString(2,emp.getLastname());
                    ps.setString(3,emp.getEmail());

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
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return  status;
    }

    @Override
    public String viewEmployee(String email) {
          Employee emp = new Employee();
        if(con.connectToDatebase()){
            String DISPLAY_ALL = "SELECT * FROM student WHERE email = ?";
            try{
                pr = con.getConnections().prepareStatement(DISPLAY_ALL);
                pr.setString(1,email);
                res = pr.executeQuery();
                if(res.next()){
                    emp.setEmail(res.getString("email"));
                    emp.setFirstname(res.getString("firstname"));
                    emp.setLastname(res.getString("lastname"));
                    emp.setDOB(res.getString("dob"));
                    emp.setAddress(res.getString("address"));
                    emp.setEmploymentDate(res.getString("employmentDate"));
                }
            } catch (SQLException e ){
                e.printStackTrace();
            }
        }

        return emp.toString();
    }
}
