package tompeixun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


public class demo01ParamServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+":"+password);
        String [] hobbies=request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));
        Map<String,String[]> allData=request.getParameterMap();
        for(Map.Entry<String,String[]> entry : allData.entrySet()){
            System.out.println(entry.getKey());
            System.out.println("-->");
            System.out.println(Arrays.toString(entry.getValue()));
        }
    }
}
