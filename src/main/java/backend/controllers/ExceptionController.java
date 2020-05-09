package backend.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/app")
public class ExceptionController {

    public ExceptionController(){}

    @GetMapping("/messageSaveGroup")
    public String exceptionMessage(HttpServletRequest request, Model model){
        Cookie exceptionCookie = WebUtils.getCookie(request,"exceptionCookie");
        request.setAttribute("exceptions", exceptionCookie.getValue().replace("+", " "));

        return "/app/messageSaveGroup.jsp";
    }

    @PostMapping("/messageSaveGroup")
    @ResponseBody
    public void backAddGroup(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.sendRedirect("/app/addGroup");
    }
}
