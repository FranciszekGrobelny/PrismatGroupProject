package backend.Services;

import backend.models.Person;

import java.sql.*;

public class DbConnectorService {

    public DbConnectorService(){}

    public static Connection Connect(){

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

        return Connect();
    }
}
