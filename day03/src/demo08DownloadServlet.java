package tompeixun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "demo08DownloadServlet",urlPatterns = "/download")
public class demo08DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String filename=request.getParameter("filename");
     String realPath=getServletContext().getRealPath("/download/"+filename);
     String mimeType=getServletContext().getMimeType(filename);
     response.setHeader("Content-type",mimeType);
     response.setHeader("Content-Disposition","attachment;filename="+filename);
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(realPath));
        BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
        byte[] arr=new byte[1024];
        int len;
        while((len=bis.read(arr))!=-1){
            bos.write(arr,0,len);
        }
        bos.close();
        bis.close();
    }
}
