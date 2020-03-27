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

    @GetMapping("/login")
    public String loginPage(){
        return "log.jsp";
    }

    @GetMapping("/rejestration")
    public String rejestrationPage(){ return "rejestration.jsp";}

    @PostMapping("/rejestration")
    @ResponseBody
    public String userRejestration(@RequestParam("login") String login,
                                   @RequestParam("password") String password,
                                   @RequestParam("email") String email,
                                   @RequestParam(value = "anotherEmail", required = false) String anotherEmail,
                                   HttpServletResponse response) throws IOException {

        Person person;
        if(anotherEmail != null){
            person = new Person(login, password, email, anotherEmail);
        }else{
            person = new Person(login, password, email);
        }

        //tu bedzie PersonDao wysylajace dane bazy
        PersonDao personDao = new PersonDao();
        personDao.create(person);

        response.sendRedirect("/app/userPage");

        return "";
    }
}
