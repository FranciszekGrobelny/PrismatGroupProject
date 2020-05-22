package backend.dao;

import backend.exceptions.FoundException;
import backend.exceptions.NotFoundException;
import backend.models.UserGroups;
import backend.services.DbConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.FileNotFoundException;
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
    private static final String READ_ALL_PARTICIPANTS_BY_GROUPID=
            "SELECT userId FROM usergroups WHERE groupsId=?";

    public UserGroups create(UserGroups userGroups) throws FileNotFoundException {

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
            FoundException.catchException(e);
        }
        return null;
    }

    public List<UserGroups> readByUserId(int userId) throws FileNotFoundException {
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
            FoundException.catchException(e);
        }

        return groupsIdList;
    }

    public UserGroups readByGroupsId(int groupsId) throws FileNotFoundException {
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
            FoundException.catchException(e);
        }

        return userGroups;
    }

    public void deleteByUserId(int userId) throws FileNotFoundException {
        try (PreparedStatement statement = dao.connect().prepareStatement(DELETE_USERGROUPS_BY_USERID_QUERY)) {
            statement.setInt(1, userId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Product not found");
            }
        } catch (Exception e) {
            FoundException.catchException(e);
        }
    }

    public void deleteByGroupsId(int groupsId) throws FileNotFoundException {
        try (PreparedStatement statement = dao.connect().prepareStatement(DELETE_USERGROUPS_BY_GROUPSID_QUERY)) {
            statement.setInt(1, groupsId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Product not found");
            }
        } catch (Exception e) {
            FoundException.catchException(e);
        }
    }

    public List<Integer> getAllParticipants(int groupsId) throws FileNotFoundException {
        List<Integer> participantsList = new ArrayList<>();

        try (PreparedStatement statement = dao.connect().prepareStatement(READ_ALL_PARTICIPANTS_BY_GROUPID)) {
            statement.setInt(1, groupsId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    participantsList.add(resultSet.getInt("userId"));
                }
            }
        } catch (Exception e) {
            FoundException.catchException(e);
        }

        return participantsList;
    }
}

