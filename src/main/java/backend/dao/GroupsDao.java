package backend.dao;

import backend.exceptions.NotFoundException;
import backend.models.Groups;
import backend.services.DbConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupsDao {

    private DbConnectorService dao;
    private Groups groups;

    @Autowired
    public GroupsDao(){ dao = new DbConnectorService();}

    private static final String CREATE_GROUPS_QUERY =
            "INSERT INTO groups(name, description, maxNumberOfPlaces, passwordGroup) VALUES (?,?,?,?)";
    private static final String READ_GROUPS_QUERY =
            "SELECT * FROM groups where name = ?";
    private static final String UPDATE_GROUPS_QUERY =
            "UPDATE groups SET name=?, description=?, maxNumberOfPlaces=?, passwordGroup=? WHERE name = ?";
    private static final String DELETE_GROUPS_QUERY =
            "DELETE FROM groups where name = ?";
    private static final String READ_ALL_GROUPS_QUERY = "SELECT * FROM groups";
    private static final String READ_ALL_GROUPS_BY_ID_QUERY = "SELECT * FROM groups WHERE id=?";

    public List<Groups> getAllGroups(){
        List<Groups> groupList = new ArrayList<>();

        try (PreparedStatement statement = dao.connect().prepareStatement(READ_ALL_GROUPS_QUERY)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    groupList.add(new Groups(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getInt("maxNumberOfPlaces"),
                            resultSet.getString("passwordGroup")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return groupList;
    }

    public Groups readGroupById(int groupId) throws SQLException {


        try (PreparedStatement statement = dao.connect().prepareStatement(READ_ALL_GROUPS_BY_ID_QUERY)) {
            statement.setInt(1, groupId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    groups = new Groups(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getInt("maxNumberOfPlaces"),
                            resultSet.getString("passwordGroup"));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groups;
    }}


    public Groups create(Groups groups) {

        try (PreparedStatement insertStatement = dao.connect().prepareStatement(CREATE_GROUPS_QUERY,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStatement.setString(1, groups.getName());
            insertStatement.setString(2, groups.getDescription());
            insertStatement.setInt(3, groups.getMaxNumberOfPlaces());
            insertStatement.setString(4, groups.getPasswordGroup());
            insertStatement.executeUpdate();

            try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    groups.setId(generatedKeys.getInt(1));
                    return groups;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Groups read(String groupsName) {
        try (PreparedStatement statement = dao.connect().prepareStatement(READ_GROUPS_QUERY)) {
            statement.setString(1, groupsName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    groups = new Groups(resultSet.getInt("id"), resultSet.getString("name"),
                            resultSet.getString("description"), resultSet.getInt("maxNumberOfPlaces"),
                            resultSet.getString("passwordGroup"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return groups;
    }

    public void update(Groups groups) {
        try (PreparedStatement statement = dao.connect().prepareStatement(UPDATE_GROUPS_QUERY)) {
            statement.setString(5, groups.getName());
            statement.setString(1, groups.getName());
            statement.setString(2, groups.getDescription());
            statement.setInt(3, groups.getMaxNumberOfPlaces());
            statement.setString(4, groups.getPasswordGroup());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String groupsName) {
        try (PreparedStatement statement = dao.connect().prepareStatement(DELETE_GROUPS_QUERY)) {
            statement.setString(1, groupsName);
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
