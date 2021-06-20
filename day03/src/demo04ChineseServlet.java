package tompeixun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "demo04ChineseServlet",urlPatterns = "/chinese")
public class demo04ChineseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-type","text/html;charset:utf-8");
       /* response.setContentType("text/html;charset:utf-8");*/
        String data="中国";
        PrintWriter out=response.getWriter();
        out.println(data);
    }
}
