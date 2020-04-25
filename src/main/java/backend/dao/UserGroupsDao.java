package backend.dao;

import backend.exceptions.NotFoundException;
import backend.models.UserGroups;
import backend.services.DbConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserGroupsDao {

    private DbConnectorService dao;
    private UserGroups userGroups = new UserGroups();

    @Autowired
    public UserGroupsDao(){ dao = new DbConnectorService();}

    private static final String CREATE_USERGROUPS_QUERY =
            "INSERT INTO usergroups(userId, groupsId) VALUES (?,?)";
    private static final String DELETE_USERGROUPS_BY_USERID_QUERY =
            "DELETE FROM usergroups where userId = ?";
    private static final String DELETE_USERGROUPS_BY_GROUPSID_QUERY =
            "DELETE FROM usergroups where groupsId = ?";
    private static final String READ_USERGROUPS_BY_USERID_QUERY=
            "SELECT * FROM usergroups WHERE userId=?";
    private static final String READ_USERGROUPS_BY_GROUPSID_QUERY=
            "SELECT * FROM usergroups WHERE groupsId=?";

    public UserGroups create(UserGroups userGroups) {

        try (PreparedStatement insertStatement = dao.connect().prepareStatement(CREATE_USERGROUPS_QUERY,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStatement.setInt(1, userGroups.getUserId());
            insertStatement.setInt(2, userGroups.getGroupsId());
            insertStatement.executeUpdate();

            try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    userGroups.setId(generatedKeys.getInt(1));
                    return userGroups;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserGroups> readByUserId(int userId) {
        List<UserGroups> groupsIdList = new ArrayList<>();
        try (PreparedStatement statement = dao.connect().prepareStatement(READ_USERGROUPS_BY_USERID_QUERY)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    groupsIdList.add(new UserGroups(
                            resultSet.getInt("id"),
                            resultSet.getInt("userId"),
                            resultSet.getInt("groupsId")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return groupsIdList;
    }

    public UserGroups readByGroupsId(int groupsId) {
        userGroups = new UserGroups();
        try (PreparedStatement statement = dao.connect().prepareStatement(READ_USERGROUPS_BY_GROUPSID_QUERY)) {
            statement.setInt(1, groupsId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    userGroups.setId(resultSet.getInt("id"));
                    userGroups.setUserId(resultSet.getInt("userId"));
                    userGroups.setGroupsId(resultSet.getInt("groupsId"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userGroups;
    }

    public void deleteByUserId(int userId) {
        try (PreparedStatement statement = dao.connect().prepareStatement(DELETE_USERGROUPS_BY_USERID_QUERY)) {
            statement.setInt(1, userId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Product not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteByGroupsId(int groupsId) {
        try (PreparedStatement statement = dao.connect().prepareStatement(DELETE_USERGROUPS_BY_GROUPSID_QUERY)) {
            statement.setInt(1, groupsId);
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

