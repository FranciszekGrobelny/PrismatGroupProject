package backend.models;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data @ToString(exclude = "password")
public class Person {
    private int id;
    private String login;
    private String password;
    private String email;
    private String anotherContact;
    private int permission;
    private LocalDateTime dateCreated;

    public Person(){}

    public Person(String login, String password, String email,  String anotherContact, int permission) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.anotherContact = anotherContact;
        this.permission = permission;
        //this.dateCreated = dateCreated;
    }

    public Person(String login, String password, String email, int permission) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.permission = permission;
        //this.dateCreated = dateCreated;
    }
    public Person(String login, String password, String email,String anotherContact) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.anotherContact = anotherContact;

    }
}

