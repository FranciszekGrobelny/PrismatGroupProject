package backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {

    @GetMapping("/login")
    public String loginPage(){
        return "log.html";
    }
    @GetMapping("/RegistrationPageAction")
    public String registrationPage()
    {
        return "RegistrationPage.html";
    }
}
