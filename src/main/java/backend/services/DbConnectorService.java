package backend.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectorService {
    public DbConnectorService(){}

    public static Connection connect(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String host = "jdbc:mysql://localhost:3306/prismat";
            String user = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(host, user, password);

            if(connection!=null) {
                System.out.println("Succesfull Connection.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return connect();
    }
}

