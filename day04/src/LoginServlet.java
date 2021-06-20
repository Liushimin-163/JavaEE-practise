package tompeixun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String code=request.getParameter("code");
   String code_session=(String)request.getSession().getAttribute("code_session");
   if(!code_session.equalsIgnoreCase(code)){
       request.setAttribute("msg","the verification code is wrong");
       request.getRequestDispatcher("/login.html").forward(request,response);
       return;
        }
    }
}
