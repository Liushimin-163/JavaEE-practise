package demo03_context_read;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "ReadFileServlet3",urlPatterns = "/readFile3")
public class ReadFileServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Properties pros=readFileUtil.readFile();
        String driverClass=pros.getProperty("driverClass");
        String url=pros.getProperty("url");
        String username=pros.getProperty("username");
        String password=pros.getProperty("password");
        PrintWriter out=response.getWriter();
        out.println("driverClass:"+driverClass);
        out.println("url:"+url);
        out.println("username:"+username);
        out.println("password:"+password);
    }
}
