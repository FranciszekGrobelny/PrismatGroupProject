package backend.controllers;

import backend.dao.ExceptionsDao;
import backend.dao.GroupsDao;
import backend.dao.PersonDao;
import backend.dao.UserGroupsDao;
import backend.models.Exceptions;
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
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/app")
public class GroupsController {

    GroupsDao groupsDao;
    UserGroupsDao userGroupsDao;
    PersonDao personDao;
    ExceptionsDao exceptionsDao;
    public GroupsController(GroupsDao groupsDao, UserGroupsDao userGroupsDao, PersonDao personDao, ExceptionsDao exceptionsDao){
        this.groupsDao = groupsDao;
        this.userGroupsDao = userGroupsDao;
        this.personDao = personDao;
        this.exceptionsDao = exceptionsDao;
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
        response.sendRedirect("/app/addGroup");
    }

    @GetMapping("/addGroup")
    public String groupList(HttpServletRequest request, Model model){
        List<Groups> groups = groupsDao.getAllGroups();
        model.addAttribute("groups",groups);

        return "/app/addGroup.jsp";
    }

    @PostMapping("/saveGroup")
    @ResponseBody
    public void saveGroup(@RequestParam("groupName") String groupName,
                          @RequestParam("passwordGroup") String passwordGroup,
                          Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cookie loginCookie = WebUtils.getCookie(request,"loginCookie");
        UserGroups userGroups;
        Groups groups = groupsDao.read(groupName);
        Person person = personDao.readByLogin(loginCookie.getValue());
        String passwordGroupFromDb = groups.getPasswordGroup();
        Exceptions exceptions;
        Cookie exceptionCookie;

        if(!(person.getId() == userGroupsDao.readByGroupsId(groups.getId()).getUserId())) {
            if(!passwordGroupFromDb.equals(passwordGroup)){
                exceptions = exceptionsDao.getExceptions("ErrorSaveGroup");
            }else {
                userGroups = new UserGroups(person.getId(), groups.getId());
                userGroupsDao.create(userGroups);
                exceptions = exceptionsDao.getExceptions("SaveGroupMessage");
            }
        }else {
            exceptions = exceptionsDao.getExceptions("MemberOfGroup");
        }
        exceptionCookie = new Cookie("exceptionCookie", URLEncoder.encode( exceptions.getExceptionDescription(), "UTF-8" ));
        loginCookie.setPath("/");
        response.addCookie(exceptionCookie);
        response.sendRedirect("/app/messageSaveGroup");
    }
}
