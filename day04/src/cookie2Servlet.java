package tompeixun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "cookie2Servlet",urlPatterns = "/cookie2")
public class cookie2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Cookie cookie=new Cookie("username","lily");
       Cookie cookie1=new Cookie("age","18");
       Cookie cookie2=new Cookie("date",new Date().getTime()+"");
        /*Cookie[] cookies=request.getCookies();
        if(cookies !=null){
            for(Cookie coo:cookies){
                if("username".equals(coo.getName())){
                    System.out.println(coo.getName()+":"+coo.getValue());
                }
            }*/
        //}
        response.addCookie(cookie);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
}
