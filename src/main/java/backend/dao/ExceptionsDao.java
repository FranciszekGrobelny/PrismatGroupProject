package backend.dao;

import backend.models.Exceptions;
import backend.services.DbConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Controller
public class ExceptionsDao {

    private DbConnectorService dao;
    private Exceptions exceptions;

    @Autowired
    public ExceptionsDao(){ dao = new DbConnectorService();}

    private static final String READ_EXCEPTIONS_QUERY =
            "SELECT * FROM exceptions where exceptionName = ?";

    public Exceptions getExceptions(String exceptionName) {
        try (PreparedStatement statement = dao.connect().prepareStatement(READ_EXCEPTIONS_QUERY)) {
            statement.setString(1, exceptionName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    exceptions = new Exceptions(resultSet.getInt("id"), resultSet.getString("exceptionName"),
                            resultSet.getString("description"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return exceptions;
    }
}
