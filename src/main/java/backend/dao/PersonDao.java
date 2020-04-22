package backend.dao;

import backend.exceptions.NotFoundException;
import backend.models.Person;
import backend.services.DbConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Controller
public class PersonDao {

    private DbConnectorService dao;
    private Person person = new Person();

    @Autowired
    public PersonDao()
    {
        dao = new DbConnectorService();
    }

    private static final String CREATE_PERSON_QUERY =
            "INSERT INTO person(login, password, email, anotherContact, permission) VALUES (?,?,?,?,?)";
    private static final String READ_PERSON_QUERY =
            "SELECT * FROM person where id = ?";
    private static final String UPDATE_PERSON_QUERY =
            "UPDATE person SET login=?, password=?, email=?, anotherContact=?, permission=? WHERE id = ?";
    private static final String DELETE_PERSON_QUERY =
            "DELETE FROM person where id = ?";
    private static final String READ_PERSON_BY_USERNAME_QUERY=
            "SELECT * FROM person WHERE login=?";

    public Person create(Person person) {

        try (PreparedStatement insertStatement = dao.connect().prepareStatement(CREATE_PERSON_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStatement.setString(1, person.getLogin());
            insertStatement.setString(2, person.getPassword());
            insertStatement.setString(3, person.getEmail());
            insertStatement.setString(4, person.getAnotherContact());
            insertStatement.setInt(5, person.getPermission());
            insertStatement.executeUpdate();

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
        person = new Person();
        try (PreparedStatement statement = dao.connect().prepareStatement(READ_PERSON_QUERY)) {
            statement.setInt(1, personId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    person.setId(resultSet.getInt("id"));
                    person.setLogin(resultSet.getString("login"));
                    person.setPassword(resultSet.getString("password"));
                    person.setEmail(resultSet.getString("email"));
                    person.setAnotherContact(resultSet.getString("anotherContact"));
                    person.setPermission(resultSet.getInt("permission"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return person;
    }

    public void update(Person person) {
        try (PreparedStatement statement = dao.connect().prepareStatement(UPDATE_PERSON_QUERY)) {
            statement.setInt(6, person.getId());
            statement.setString(1, person.getLogin());
            statement.setString(2, person.getPassword());
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getAnotherContact());
            statement.setInt(5, person.getPermission());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer personId) {
        try (PreparedStatement statement = dao.connect().prepareStatement(DELETE_PERSON_QUERY)) {
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

    public Person readByLogin(String login){
        person = new Person();
        try (PreparedStatement statement = dao.connect().prepareStatement(READ_PERSON_BY_USERNAME_QUERY)) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    person.setId(resultSet.getInt("ID"));
                    person.setLogin(resultSet.getString("Login"));
                    person.setPassword(resultSet.getString("Password"));
                    person.setEmail(resultSet.getString("Email"));
                    person.setAnotherContact(resultSet.getString("AnotherContact"));
                    person.setPermission(resultSet.getInt("Permission"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return person;
    }
}

