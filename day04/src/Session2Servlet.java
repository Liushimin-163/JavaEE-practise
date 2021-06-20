package tompeixun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Session2Servlet",urlPatterns = "/session2")
public class Session2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        System.out.println(session);
        Cookie cookie=new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(10000);
        response.addCookie(cookie);
    }
}
