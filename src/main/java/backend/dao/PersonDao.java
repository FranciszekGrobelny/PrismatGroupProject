package backend.dao;

import backend.exeptions.NotFoundException;
import backend.models.Person;
import backend.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonDao {
    private static final String CREATE_PERSON_QUERY =
            "INSERT INTO persons(login, password, email, anotherEmail) VALUES (?,?,?,?);";
    private static final String READ_PERSON_QUERY =
            "SELECT * FROM persons where id = ?;";
    private static final String UPDATE_PERSON_QUERY =
            "UPDATE persons SET login=?, password=?, email=?, anotherEmail=? WHERE id = ?;";
    private static final String DELETE_PERSON_QUERY =
            "DELETE FROM persons where id = ?;";

    public Person create(Person person) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_PERSON_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, person.getLogin());
            insertStm.setString(2, person.getPassword());
            insertStm.setString(3, person.getEmail());
            insertStm.setString(4, person.getAnotherEmail());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
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
        Person person = new Person();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_PERSON_QUERY)
        ) {
            statement.setInt(1, personId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    person.setId(resultSet.getInt("id"));
                    person.setLogin(resultSet.getString("login"));
                    person.setPassword(resultSet.getString("password"));
                    person.setEmail(resultSet.getString("email"));
                    person.setAnotherEmail(resultSet.getString("anotherEmail"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;

    }

    public void update(Person person) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PERSON_QUERY)) {
            statement.setInt(5, person.getId());
            statement.setString(1, person.getLogin());
            statement.setString(2, person.getPassword());
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getAnotherEmail());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(Integer personId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PERSON_QUERY)) {
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
