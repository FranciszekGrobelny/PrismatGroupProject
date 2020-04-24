package backend.controllers;

import backend.dao.GroupsDao;
import backend.models.Groups;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/app")
public class GroupsController {

    GroupsDao groupsDao;
    public GroupsController(GroupsDao groupsDao){
        this.groupsDao = groupsDao;
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
}
