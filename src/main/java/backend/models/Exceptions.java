package backend.models;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class Exceptions {

    private int id;
    private String exceptionName;
    private  String exceptionDescription;

    public Exceptions(int id, String exceptionName, String exceptionDescription){
        this.id = id;
        this.exceptionName = exceptionName;
        this.exceptionDescription = exceptionDescription;
    }
}
