package backend.controllers;

import backend.dao.PersonDao;
import backend.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class StartPageController {

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
    public String checkLogin(@RequestParam("login") String login,
                             @RequestParam("password") String password,
                             HttpServletResponse response) throws IOException {

        XmlWebApplicationContext context = new XmlWebApplicationContext();
        PersonDao personDao = context.getBean(PersonDao.class);
        Person person = personDao.readByLogin(login);
        String passwordFromDb = person.getPassword();

        if(person.getLogin()==null || !passwordFromDb.equals(password)){
            response.sendRedirect("/login");
        }else {
            response.sendRedirect("/app/userPage");
        }
        return "";
    }
}
