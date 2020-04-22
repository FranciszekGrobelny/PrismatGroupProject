//package backend.filters;
//
//import backend.dao.PersonDao;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter("/app/*")
//public class SecureFilter implements Filter {
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpSession session = ((HttpServletRequest)req).getSession();
//        session.setMaxInactiveInterval(60*10); //10 minut sesja jest aktywna
//        HttpServletResponse httpResponse = (HttpServletResponse) resp;
//
//        PersonDao personDao = new PersonDao();
//
//        String personEmail = (String) session.getAttribute("email");
//        String personPassword = (String) session.getAttribute("password");
//        int personId = personDao.idByEmail(personEmail);
//
//        if(!(personDao.passwordAuthorization(personId, personPassword))){
//            httpResponse.sendRedirect("/login");
//        }
//        else{
//            chain.doFilter(req, resp);
//        }
//
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
