package tompeixun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "demo04WriteImgServlet",urlPatterns="/writeImg")
public class demo04WriteImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String realPath=getServletContext().getRealPath("/download/a.jpg");
        BufferedInputStream bis= new BufferedInputStream(new FileInputStream(realPath));
        OutputStream os=response.getOutputStream();
        byte[] arr=new byte[1024];
        int len;
        while((len=bis.read(arr))!=-1){
            os.write(arr,0,len);
        }
        os.close();
        bis.close();
    }
}
