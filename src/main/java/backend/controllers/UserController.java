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
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class UserController {

    GroupsDao groupsDao;
    UserGroupsDao userGroupsDao;
    PersonDao personDao;
    public UserController(GroupsDao groupsDao, UserGroupsDao userGroupsDao,PersonDao personDao){
        this.personDao = personDao;
        this.groupsDao = groupsDao;
        this.userGroupsDao = userGroupsDao;
    }
    @GetMapping("/userPage") 
    public String userPage(HttpServletRequest request, Model model ) throws SQLException {
                                                 // JAK BEDZIE USER_DAO
        Cookie loginCookie = WebUtils.getCookie(request,"loginCookie");

        Person person = personDao.readByLogin(loginCookie.getValue());
        List<UserGroups> usersGroupsList = userGroupsDao.readByUserId(person.getId());
        List<Groups> groups = new ArrayList<>();

        for(UserGroups group : usersGroupsList ){
            groups.add(groupsDao.readGroupById(group.getGroupsId()));
        }

        model.addAttribute("groups",groups);
        request.setAttribute("login", loginCookie.getValue());
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
}