package backend.controllers;

import backend.dao.GroupsDao;
import backend.models.Groups;
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
public class UserController {

    GroupsDao groupsDao;
    public UserController(GroupsDao groupsDao){
        this.groupsDao = groupsDao;
    }
    @GetMapping("/userPage")
    public String userPage(HttpServletRequest request, Model model ){
                                                 // JAK BEDZIE USER_DAO
        List<Groups> groups = groupsDao.getAllGroups();
        System.out.println("gruoa "+groups.toString());
        model.addAttribute("groups",groups);
        Cookie loginCookie = WebUtils.getCookie(request,"loginCookie");
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
