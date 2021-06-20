package demo2_context_file;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "File2Servlet",urlPatterns = "/file2")
public class File2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream in= getServletContext().getResourceAsStream("/a.jpg");
        ServletOutputStream out=response.getOutputStream();
        byte[] b=new byte[1024];
        int len=0;
        while((len=in.read(b))!=-1){
            out.write(b,0,len);
        }
       out.close();
        in.close();
    }
}
