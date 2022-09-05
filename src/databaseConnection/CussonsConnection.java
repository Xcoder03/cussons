package databaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CussonsConnection {
    Connection connection;
    public boolean connectToDatebase(){


          try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cussons", "root","");
             return true;
          }catch (SQLException e){
            e.printStackTrace();
          }
          return  false;
    }

    public Connection getConnections() {
        return connection;
    }

}
