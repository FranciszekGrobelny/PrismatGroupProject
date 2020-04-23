package backend.models;

public class UserGroups {

    private int id;
    private int userId;
    private int groupsId;

    public UserGroups(){}

    public UserGroups(int id, int userId, int groupsId){
        this.id = id;
        this.userId = userId;
        this.groupsId = groupsId;
    }

    public UserGroups(int userId, int groupsId){
        this.userId = userId;
        this.groupsId = groupsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) { this.userId = userId; }

    public int getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(int groupsId) { this.groupsId = groupsId; }

    @Override
    public String toString() {
        return "UserGroups{" +
                "userId='" + userId + '\'' +
                ", groupsId='" + groupsId + '\'' +
                '}';
    }
}
