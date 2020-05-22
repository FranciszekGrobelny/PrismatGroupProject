package backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

@Controller
@RequestMapping("/app")
public class WebRtcController {

    @GetMapping("/streamPage")
    public String getStreamPage(HttpServletRequest request, Model model) throws FileNotFoundException {

        return "/app/streamPage.jsp";
    }

}
