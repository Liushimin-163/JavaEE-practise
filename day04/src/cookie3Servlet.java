package tompeixun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cookie3Servlet",urlPatterns = "/cookie3")
public class cookie3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Cookie[] cookies=request.getCookies();
        if(cookies !=null){
            for(Cookie coo:cookies){
               String name=coo.getName();
               String value=coo.getValue();
                System.out.println(name+":"+value);
            }
        }
    }
}
