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
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class StartPageController {

    private Person person;

    @GetMapping("/login")
    public String loginPage(){
        return "log.jsp";
    }

    @GetMapping("/rejestration")
    public String rejestrationPage(){ return "rejestration.jsp";}

    @PostMapping("/rejestration")
    @ResponseBody
    public String userRejestration(@RequestParam(value = "login", required = true) String login,
                                   @RequestParam(value = "password", required = true) String password,
                                   @RequestParam(value = "email", required = true) String email,
                                   @RequestParam(value = "anotherEmail", required = false) String anotherEmail,
                                   @RequestParam("permission") boolean permission,
                                   HttpServletResponse response) throws IOException {

        person = new Person(login, password, email, anotherEmail, permission);

        //tu bedzie PersonDao wysylajace dane bazy
        PersonDao personDao = new PersonDao();
        personDao.create(person);

        response.sendRedirect("/app/userPage");

        return "";
    }
}
