package backend.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DbConnectorService {

    public Connection connect() throws SQLException {

        String host = "jdbc:mysql://localhost:3308/prismat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false=false&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return DriverManager.getConnection(host, user, password);
    }
}

