package backend.controllers;

import backend.dao.GroupsDao;
import backend.dao.PersonDao;

import backend.dao.UserGroupsDao;
import backend.models.Groups;
import backend.models.Person;
import backend.models.UserGroups;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import java.security.spec.RSAOtherPrimeInfo;

import java.util.List;

@Controller
@RequestMapping("/app")
public class UserController {

    private GroupsDao groupsDao;
    private UserGroupsDao userGroupsDao;
    private PersonDao personDao;

    public UserController(GroupsDao groupsDao, UserGroupsDao userGroupsDao,PersonDao personDao){
        this.personDao = personDao;
        this.groupsDao = groupsDao;
        this.userGroupsDao = userGroupsDao;
    }

    @GetMapping("/userPage") 
    public String userPage(HttpServletRequest request,
                           Model model ) throws SQLException, FileNotFoundException {

        Cookie loginCookie = WebUtils.getCookie(request,"loginCookie");
        assert loginCookie != null;
        Person person = personDao.readByLogin(loginCookie.getValue());
        List<UserGroups> usersGroupsList = userGroupsDao.readByUserId(person.getId());
        List<Groups> groups = new ArrayList<>();

        for(UserGroups group : usersGroupsList ){
            groups.add(groupsDao.readGroupById(group.getGroupsId()));
        }

        model.addAttribute("groups",groups);
        request.setAttribute("login", loginCookie.getValue());

        Person personData = personDao.readByLogin(loginCookie.getValue());
        request.setAttribute("personData", personData);

        return "/app/userPage.jsp";
    }

    @GetMapping("/deleteGroupFromUser")
    public String deleteGroupFromUser(@RequestParam(name = "id") int id) throws FileNotFoundException, SQLException {

        userGroupsDao.deleteByGroupsId(id);
        return "redirect:/app/userPage";
    }

    @GetMapping("/add")
    public String addGroup(){ return "/app/addGroup.jsp"; }

    @PostMapping("/add")
    public void addGroupAction(@RequestParam(name = "name") String name,
                               @RequestParam(name = "description") String description,
                               @RequestParam(name = "maxNumberOfPlaces") int maxNumber,
                               @RequestParam(name = "passwordGroup") String passwordGroup,
                               HttpServletResponse response) throws IOException {
        Groups group = new Groups(name,description,maxNumber, passwordGroup);
        groupsDao.create(group);
       response.sendRedirect("/app/userPage");
    }

    @PostMapping("/userPageEdit")
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
        System.out.println("-------------------"+person.toString());
        personDao.update(person);
        response.sendRedirect("/app/userPage");
    }
    @PostMapping("/logout")
    public void logoutUser(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        System.out.println("-------------------Wylogowanie");
        Cookie deleteLoginCookie = WebUtils.getCookie(request,"loginCookie");
        System.out.printf(deleteLoginCookie.getName());
        deleteLoginCookie.setValue("");
        deleteLoginCookie.setPath("/");
        deleteLoginCookie.setMaxAge(0);
        response.addCookie(deleteLoginCookie);
        response.sendRedirect("/");

    }
}

