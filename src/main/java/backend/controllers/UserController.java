package backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class UserController {
    @GetMapping("/userPage")
    public String userPage(){
        return"/app/userPage.jsp";
    }

}
