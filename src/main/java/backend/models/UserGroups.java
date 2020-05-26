package backend.models;

import lombok.Data;
import lombok.ToString;


@Data @ToString(exclude = "id")
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
}
