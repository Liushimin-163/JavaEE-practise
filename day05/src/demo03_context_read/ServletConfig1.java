package demo03_context_read;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ServletConfig1")
public class ServletConfig1 extends HttpServlet {
    ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);

        this.config=config;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String par=config.getInitParameter("filename");
        System.out.println("filename:"+par);
        InputStream in=getServletContext().getResourceAsStream(par);
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
