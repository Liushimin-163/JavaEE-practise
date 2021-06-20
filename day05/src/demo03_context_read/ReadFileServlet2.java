package demo03_context_read;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "ReadFileServlet2",urlPatterns = "/readFile2")
public class ReadFileServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        ServletContext context=this.getServletContext();
        String path=context.getRealPath("/WEB-INF/classes/test1.properties");
        FileInputStream in=new FileInputStream(path);
        Properties pros=new Properties();
        pros.load(in);
        out.println("Company:"+pros.getProperty("Company"));
        out.println("Address:"+pros.getProperty("Address"));
    }
}
