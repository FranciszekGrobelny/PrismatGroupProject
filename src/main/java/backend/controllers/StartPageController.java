package backend.controllers;

import backend.dao.PersonDao;
import backend.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
public class StartPageController {

    private PersonDao personDao;
    public StartPageController(PersonDao personDao){
        this.personDao = personDao;
    }

    @GetMapping("/login")
    public String loginPage(){

        return "log.html";
    }

    @GetMapping("/registrationPageAction")
    public String registrationPage()
    {

        return "RegistrationPage.html";
    }

    @PostMapping("/login")
    @ResponseBody
    public void checkLogin(@RequestParam("login") String login,
                           @RequestParam("password") String password,
                           HttpServletResponse response) throws IOException {

        Person person = personDao.readByLogin(login);
        String passwordFromDb = person.getPassword();

        if(person.getLogin()==null || !passwordFromDb.equals(password)){
            response.sendRedirect("/login");
        }else {
            response.sendRedirect("/app/userPage");
        }
    }

    @PostMapping("/registrationPageAction")
    @ResponseBody
    public void checkRegistration(@RequestParam("login") String login,
                                  @RequestParam("email") String email,
                                  @RequestParam(value = "anotherContact", required = false) String anotherContact,
                                  @RequestParam("password") String password,
                                  @RequestParam("teacher") boolean isTeacher,
                                  HttpServletResponse response) throws IOException {
        Person person;
        LocalDateTime dateCreated = LocalDateTime.now();
        if(anotherContact.equals("")){
            person = new Person(login, password, email, isTeacher, dateCreated);
        }else{
            person = new Person(login, password, email, anotherContact, isTeacher, dateCreated);
        }

        personDao.create(person);
        response.sendRedirect("/app/userPage");
    }
}
