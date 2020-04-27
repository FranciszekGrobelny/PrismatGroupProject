package backend.controllers;

import backend.dao.GroupsDao;
import backend.dao.PersonDao;
import backend.models.Groups;
import backend.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;

@Controller
@RequestMapping("/app")
public class UserController {

    GroupsDao groupsDao;
    PersonDao personDao;
    public UserController(GroupsDao groupsDao,PersonDao personDao){
        this.groupsDao = groupsDao;
        this.personDao = personDao;
    }
    @GetMapping("/userPage")
    public String userPage(HttpServletRequest request, Model model ){
                                                 // JAK BEDZIE USER_DAO
        List<Groups> groups = groupsDao.getAllGroups();
        System.out.println("gruoa "+groups.toString());
        model.addAttribute("groups",groups);
        Cookie loginCookie = WebUtils.getCookie(request,"loginCookie");
        Person personData = personDao.readByLogin(loginCookie.getValue());
        request.setAttribute("personData", personData);
        return "/app/userPage.jsp";
    }

    @GetMapping("/delete")
    public String deleteUserGroup(@RequestParam(name = "name") String name){
        groupsDao.delete(name);
        return "redirect:/app/userPage";
    }

    @GetMapping("/add")
    public String addGroup(){
        return "/app/addGroup.jsp";
    }

    @PostMapping("/add")
    @ResponseBody
    public void addGroupAction(@RequestParam(name = "name") String name,
                               @RequestParam(name = "description") String description,
                               @RequestParam(name = "maxNumberOfPlaces") int maxNumber,
                               @RequestParam(name = "passwordGroup") String passwordGroup,
                               HttpServletResponse response) throws IOException {
        Groups group = new Groups(name,description,maxNumber, passwordGroup);
        groupsDao.create(group);
       response.sendRedirect("/app/userPage");
    }

    @PostMapping("/userPage")
    @ResponseBody
    public void editPersonAction(@RequestParam(name = "password") String password,
                                 @RequestParam(name = "email") String email,
                                 @RequestParam(name = "anotherContact") String anotherContact,
                                 Model model, HttpServletResponse response,
                                 HttpServletRequest request)throws IOException {

        Cookie loginCookie = WebUtils.getCookie(request,"loginCookie");
        Person person = personDao.readByLogin(loginCookie.getValue());


        if (!"".equals(password)){
            person.setPassword(password);
        }
        if (!"".equals(email)){
            person.setEmail(email);
        }
        if (!"".equals(anotherContact)){
            person.setAnotherContact(anotherContact);
        }
        personDao.update(person);
        response.sendRedirect("/app/userPage");
    }


}
