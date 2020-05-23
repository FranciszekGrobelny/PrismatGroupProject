package backend.controllers;

import backend.dao.GroupsDao;
import backend.dao.PersonDao;
import backend.dao.UserGroupsDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

@Controller
@RequestMapping("/app")
public class WebRtcController {

    UserGroupsDao userGroupsDao;
    GroupsDao groupsDao;
    PersonDao personDao;

//    @PostMapping("/streamPage")
//    @ResponseBody
//    public void checkIdOfGroup(@RequestParam(name = "name") String name,
//                               HttpServletResponse response){
//
//
//    }

    @GetMapping("/streamPage")
    public String getStreamPage(HttpServletRequest request, Model model) throws FileNotFoundException {

//        var allParticipants = userGroupsDao.getAllParticipants(1);

        return "/app/streamPage.jsp";
    }
}
