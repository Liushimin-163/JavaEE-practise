package tompeixun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Session4Servlet",urlPatterns = "/keep")
public class Session4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String id=session.getId();
        Cookie cookie=new Cookie("JSESSIONID",id);
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        response.getWriter().write(id);
    }
}
