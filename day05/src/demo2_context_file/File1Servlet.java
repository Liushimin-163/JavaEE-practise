package demo2_context_file;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet(name = "File1Servlet",urlPatterns = "/file1")
public class File1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FileServlet.doGet");
        ServletContext sc=getServletContext();
        String realPath=sc.getRealPath("/web下文件.txt");
        System.out.println(realPath);
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(realPath)));
        String s=br.readLine();
        br.close();
        System.out.println(s);
    }
}
