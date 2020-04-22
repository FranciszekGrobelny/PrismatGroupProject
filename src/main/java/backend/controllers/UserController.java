package backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class UserController {

    @GetMapping("/userPage")
    public String userPage(HttpServletRequest request){
                                                 // JAK BEDZIE USER_DAO
        List<String> groups = new ArrayList<>();// = userDao.getUserGroups;
        groups.add("Takie tam zajecia z komputerami");
        groups.add("Sterowniki i pierniki");
        groups.add("Wedrowki z programistami");
        request.setAttribute("groups",groups);
        Cookie loginCookie = WebUtils.getCookie(request,"loginCookie");
        request.setAttribute("login", loginCookie.getValue());
        return"/app/userPage.jsp";
    }
}
