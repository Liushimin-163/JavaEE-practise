package demo03_context_read;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "ReadFileServlet",urlPatterns = "/readFile")
public class ReadFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context=this.getServletContext();
        PrintWriter out=response.getWriter();
        InputStream in=context.getResourceAsStream("/WEB-INF/classes/test1.properties");
        Properties pros=new Properties();
        pros.load(in);
        out.println("Company:"+pros.getProperty("Company"));
        out.println("Address:"+pros.getProperty("Address"));
    }
}
