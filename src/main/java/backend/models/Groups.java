package backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data @ToString @AllArgsConstructor
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
}
