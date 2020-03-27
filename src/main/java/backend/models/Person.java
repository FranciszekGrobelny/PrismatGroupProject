package backend.models;

public class Person {

    private int id;
    private String login;
    private String password;
    private String email;
    private String anotherEmail;

    public Person(){}

    public Person(String login, String password, String email){
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Person(String login, String password, String email, String anotherEmail) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.anotherEmail = anotherEmail;
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

    public String getAnotherEmail() {
        return anotherEmail;
    }

    public void setAnotherEmail(String anotherEmail) {
        this.anotherEmail = anotherEmail;
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", anotherEmail='" + anotherEmail + '\'' +
                '}';
    }
}
