package tompeixun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "lastServlet",urlPatterns = "/last")
public class lastServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=utf-8");
       Date date= new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
        String format1=format.format(date);
        System.out.println(format1);
        Cookie cookie=new Cookie("time",format1);
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie cookie1:cookies){
                String name=cookie1.getName();
                if("time".equals(name)){
                    String value=cookie1.getValue();
                    response.getWriter().println("上次访问时间："+value);
                    break;
                }
            }
        }
    }
}
