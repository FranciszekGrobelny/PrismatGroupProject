package backend.models;

import java.time.LocalDateTime;

public class Person {
    private int id;
    private String login;
    private String password;
    private String email;
    private String anotherContact;
    private int permission;
    private LocalDateTime dateCreated;

    public Person(){}

    public Person(String login, String password, String email, String anotherContact, int permission,LocalDateTime dateCreated) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.anotherContact = anotherContact;
        this.permission = permission;
        this.dateCreated = dateCreated;
    }

    public Person(String login, String password, String email, int permission, LocalDateTime dateCreated) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.permission = permission;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getanotherContact() {
        return anotherContact;
    }

    public void setanotherContact(String anotherContact) {
        this.anotherContact = anotherContact;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission){
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", anotherContact='" + anotherContact + '\'' +
                ", anotherContact='" + permission + '\'' +
                '}';
    }
}

