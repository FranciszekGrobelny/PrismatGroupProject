package backend.dao;

import backend.exeptions.NotFoundException;
import backend.models.Person;
import backend.utils.DbUtil;
import backend.Services.DbConnectorService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonDao {

    private DbConnectorService dao;
    private Person person;

    public PersonDao()
    {
        dao = new DbConnectorService();
    }

    private static final String CREATE_PERSON_QUERY =
            "INSERT INTO persons(login, password, email, anotherEmail, permission) VALUES (?,?,?,?,?);";
    private static final String READ_PERSON_QUERY =
            "SELECT * FROM persons where id = ?;";
    private static final String UPDATE_PERSON_QUERY =
            "UPDATE persons SET login=?, password=?, email=?, anotherEmail=?, permission=? WHERE id = ?;";
    private static final String DELETE_PERSON_QUERY =
            "DELETE FROM persons where id = ?;";

    public Person create(Person person) {

        try (PreparedStatement insertStatement = dao.Connect().prepareStatement(CREATE_PERSON_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStatement.setString(1, person.getLogin());
            insertStatement.setString(2, person.getPassword());
            insertStatement.setString(3, person.getEmail());
            insertStatement.setString(4, person.getAnotherEmail());
            insertStatement.setBoolean(5, person.getPermission());
            ResultSet resultSet = insertStatement.executeQuery();

            if (resultSet == null) {
                throw new RuntimeException("Execute update returned " + resultSet);
            }

            try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    person.setId(generatedKeys.getInt(1));
                    return person;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Person read(Integer personId) {

        try (PreparedStatement statement = dao.Connect().prepareStatement(READ_PERSON_QUERY)) {
            statement.setInt(1, personId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    person.setId(resultSet.getInt("ID"));
                    person.setLogin(resultSet.getString("Login"));
                    person.setPassword(resultSet.getString("Password"));
                    person.setEmail(resultSet.getString("Email"));
                    person.setAnotherEmail(resultSet.getString("AnotherContact"));
                    person.setPermission(resultSet.getBoolean("Permission"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return person;
    }

    public void update(Person person) {
        try (PreparedStatement statement = dao.Connect().prepareStatement(UPDATE_PERSON_QUERY)) {
            statement.setInt(6, person.getId());
            statement.setString(1, person.getLogin());
            statement.setString(2, person.getPassword());
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getAnotherEmail());
            statement.setBoolean(5, person.getPermission());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer personId) {
        try (PreparedStatement statement = dao.Connect().prepareStatement(DELETE_PERSON_QUERY)) {
            statement.setInt(1, personId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Product not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
