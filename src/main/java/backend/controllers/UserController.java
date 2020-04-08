package backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class UserController {

    @GetMapping("/userPage")
    public String userPage(HttpServletRequest request){

        List<String> groups = new ArrayList<>();
        groups.add("Technika Analogowa 2020");
        groups.add("Robótki na drutach z Panią Justyną");

        request.setAttribute("groups",groups);
        return"/app/userPage.jsp";
    }
}
