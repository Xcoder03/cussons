package view;

import model.Employee;
import model.Orders;
import model.Produce;
import model.RawMaterials;
import services.EmployeeMethods;
import services.OtherProducts;
import services.ProductMethods;

import javax.swing.text.View;
import java.util.Scanner;

public class DashBoard {
    Scanner a = new Scanner(System.in).useDelimiter("\n");
    Scanner em = new Scanner(System.in).useDelimiter("\n");
    int choice =0;

   OtherProducts op = new OtherProducts();
   ProductMethods pm = new ProductMethods();
   EmployeeMethods eme = new EmployeeMethods();

   Employee emp = new Employee();
   Orders ords = new Orders();
   Produce pd = new Produce();
   RawMaterials rw = new RawMaterials();

   public void employee(){
       do{
           System.out.println("==================================================");
           System.out.println("                    >> Employee <<                 ");
           System.out.println("==================================================");
           System.out.println();

           System.out.println("  >>  What would you like to do.  <<   \n >> (1) Register employee\n >> (2) View employee by email" +
                   "\n >> (3) Update employee by email\n >> (4) Delete employee by email\n >> (5) Back to main menu");

           choice = a.nextInt();
           switch (choice){
               case 1:
                   System.out.println("Enter employee firstname");
                   emp.setFirstname(em.next());
                   System.out.println("Enter employee lasttname");
                   emp.setLastname(em.next());
                   System.out.println("Enter employee date of birth>> format: dd-mm-yyyy");
                   emp.setDOB(em.next());
                   System.out.println("Enter employee valid email");
                   emp.setEmail(em.next());
                   System.out.println("Enter employee address");
                   emp.setAddress(em.next());
                   System.out.println("Enter employee department");
                   emp.setDepartment(em.next());
                   System.out.println("Enter employee date of employment>> format: dd-mm-yyyy");
                   emp.setEmploymentDate(em.next());
                   System.out.println(eme.registerEmployee(emp));
                   break;
               case 2:
                   System.out.println(eme.viewEmployee());
                   break;
               case 3:
                   System.out.println("Enter employee email");
                   emp.setEmail(em.next());
                   System.out.println("Enter employee firstName");
                   emp.setFirstname(em.next());
                   System.out.println("Enter emplyee lastName");
                   emp.setLastname(em.next());
                   System.out.println(eme.updateEmployee(emp));
                   break;

               case 4:
                   System.out.println("Enter employee email");
                   emp.setEmail(em.next());
                   System.out.println("Do you wish to delete employee with email "+ emp.getEmail()+" ?\n >> Y/N ");
                   System.out.println(eme.deleteEmployee(emp.getEmail(), em.next()));
                   break;
               case 5:
                   DashBoard db = new DashBoard();
                   db.menuHolder();
                   break;
               default:
                   System.out.println("  >>  Enter valid option");
           }
       }while(choice != 5);

   }



    public void products(){
        do{
            System.out.println("==================================================");
            System.out.println("                    >> Products <<                 ");
            System.out.println("==================================================");
            System.out.println();

            System.out.println("  >>  What would you like to do.  <<   \n >> (1) Upload a product\n >> (2) View products" +
                    "\n >> (3) discontinue a product  by name\n >> (4) Back to main menu");
        }
    }


    public void menuHolder(){
        int choice;
        do{
            System.out.println("==================================================");
            System.out.println("               >> Cussons  Automation  System  <<             ");
            System.out.println("               >> Welcome Back Mr Greg  <<             ");
            System.out.println("==================================================");
            System.out.println();
            System.out.println("  >>  Enter a selection: ");
            System.out.println("  >>  (1) Orders\n  >>  (2) Products\n  >>  (3) Employee\n  >> (4) Sales\n  >> (5) Exit");
            choice = b.nextInt();
            switch (choice){
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("  >>  Goodbye");
                    break;
                default:
                    System.out.println("Enter valid choice");
            }

        } while (choice !=3);
    }
}
