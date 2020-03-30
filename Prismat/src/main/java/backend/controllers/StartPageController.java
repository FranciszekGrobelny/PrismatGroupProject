package backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class StartPageController {

    String login1 = "root";//atrybyty
    String password1 = "root";


    @GetMapping("/login")
    public String loginPage(){
        return "log.jsp";
    }
    @PostMapping("/login")
    @ResponseBody
    public String checkLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpServletResponse response) throws IOException {

        if ( login1.equals(username) &&  password1.equals(password)) {
             response.sendRedirect("/app/userPage");
        }else {
                response.sendRedirect("/login");
        }
        return "";
    }
}
