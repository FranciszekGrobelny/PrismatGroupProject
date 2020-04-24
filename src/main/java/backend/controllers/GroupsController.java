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
import java.util.List;

@Controller
@RequestMapping("/app")
public class GroupsController {

    GroupsDao groupsDao;
    UserGroupsDao userGroupsDao;
    PersonDao personDao;
    public GroupsController(GroupsDao groupsDao, UserGroupsDao userGroupsDao, PersonDao personDao){
        this.groupsDao = groupsDao;
        this.userGroupsDao = userGroupsDao;
        this.personDao = personDao;
    }

    @PostMapping("/addGroup")
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

    @GetMapping("/addGroup")
    public String groupList(HttpServletRequest request, Model model ){
        List<Groups> groups = groupsDao.getAllGroups();
        System.out.println("Success!!!");
        System.out.println(""+groups.toString());
        model.addAttribute("groups",groups);

        return "/app/addGroup.jsp";
    }

    @PostMapping("/saveGroup")
    @ResponseBody
    public void saveGroup(@RequestParam("groupName") String groupName,
                          @RequestParam("passwordGroup") String passwordGroup,
                          HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cookie loginCookie = WebUtils.getCookie(request,"loginCookie");
        UserGroups userGroups;
        Groups groups = groupsDao.read(groupName);
        Person person = personDao.readByLogin(loginCookie.getValue());
        String passwordGroupFromDb = groups.getPasswordGroup();

        if(!passwordGroupFromDb.equals(passwordGroup)){
            response.sendRedirect("/app/addGroup");
            System.out.println("Problem with password.");
        }else {
            userGroups = new UserGroups(person.getId() ,groups.getId());
            userGroupsDao.create(userGroups);

            response.sendRedirect("/app/addGroup");
        }
    }
}
