package backend.filters;

import backend.dao.PersonDao;
import backend.models.Person;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/app/*")
public class SecureFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        PersonDao personDao = new PersonDao();
        try {
            Cookie loginCookie = WebUtils.getCookie((HttpServletRequest) req,"loginCookie");
            System.out.println("----------------------------filtr login = "+loginCookie.getValue());
            Person person = personDao.readByLogin(loginCookie.getValue());
            if (person == null) {
                System.out.println("----------------------------filtr person = "+person.toString());
                ((HttpServletResponse)resp).sendRedirect("/login");
            } else {
                chain.doFilter(req, resp);
            }
        }catch(NullPointerException ex){
            ex.getMessage();
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
