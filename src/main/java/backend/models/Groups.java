package backend.models;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class Groups {
    private int id;
    private String name;
    private String description;
    private int maxNumberOfPlaces;
    private String passwordGroup;

    public Groups(){}

    public Groups(String name, String description, int maxNumberOfPlaces, String passwordGroup) {
        this.name = name;
        this.description = description;
        this.maxNumberOfPlaces = maxNumberOfPlaces;
        this.passwordGroup = passwordGroup;
    }

    public Groups(int id, String name, String description, int maxNumberOfPlaces, String passwordGroup){
        this.id = id;
        this.name = name;
        this.description = description;
        this.maxNumberOfPlaces = maxNumberOfPlaces;
        this.passwordGroup = passwordGroup;
    }



}
