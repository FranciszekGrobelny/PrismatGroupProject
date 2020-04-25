package backend.controllers;

import backend.dao.PersonDao;
import backend.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class StartPageController {

    private PersonDao personDao;
    public StartPageController(PersonDao personDao){

        this.personDao = personDao;
    }

    @GetMapping("/login")
    public String loginPage(){

        return "log.jsp";
    }

    @GetMapping("/registrationPageAction")
    public String registrationPage()
    {
        return "RegistrationPage.jsp";
    }

    @PostMapping("/login")
    @ResponseBody
    public void checkLogin(@RequestParam("login") String login,
                           @RequestParam("password") String password,
                           HttpServletResponse response) throws IOException {

        Person person = personDao.readByLogin(login);
        String loginFromDb = person.getLogin();
        String passwordFromDb = person.getPassword();

        if(loginFromDb==null || !passwordFromDb.equals(password) && loginFromDb.equals(login)){
            response.sendRedirect("/login");
        }else {
            Cookie loginCookie = new Cookie("loginCookie", login);
            loginCookie.setPath("/");
            response.addCookie(loginCookie);
            response.sendRedirect("/app/userPage");
        }
    }

    @PostMapping("/registrationPageAction")
    @ResponseBody
    public void checkRegistration(@RequestParam("login") String login,
                                  @RequestParam("email") String email,
                                  @RequestParam(value = "anotherContact", required = false) String anotherContact,
                                  @RequestParam("password") String password,
                                  @RequestParam(value = "isTeacher", required = false) boolean isTeacher,
                                  @org.jetbrains.annotations.NotNull HttpServletResponse response) throws IOException {
        Person person;
        int permission = 0;
        if(isTeacher==true){permission=1;}

        if(anotherContact.equals("")){
            person = new Person(login, password, email, permission);
        }else{
        person = new Person(login, password, email, anotherContact, permission);
        }

        personDao.create(person);
        response.sendRedirect("/login");
    }
}
