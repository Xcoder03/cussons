package view;

import model.Employee;
import model.Orders;
import model.Produce;
import model.RawMaterials;
import services.OtherProducts;
import services.ProductMethods;

import java.util.Scanner;

public class view {
    Scanner a = new Scanner(System.in).useDelimiter("\n");
    Scanner b = new Scanner(System.in).useDelimiter("\n");
    int choice =0;

   OtherProducts op = new OtherProducts();
   ProductMethods pm = new ProductMethods();

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
