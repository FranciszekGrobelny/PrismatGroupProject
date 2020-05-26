package backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data @ToString @AllArgsConstructor
public class Exceptions {

    private int id;
    private String exceptionName;
    private  String exceptionDescription;

}
