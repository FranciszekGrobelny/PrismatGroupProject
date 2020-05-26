package backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data @ToString(exclude = "id") @AllArgsConstructor
public class UserGroups {

    private int id;
    private int userId;
    private int groupsId;

    public UserGroups(){}

    public UserGroups(int userId, int groupsId){
        this.userId = userId;
        this.groupsId = groupsId;
    }
}
