package tompeixun;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "checkCodeServlet",urlPatterns="/checkCode")
public class checkCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String srcCode="AUHERSKLMNliguspof0123456789";
       StringBuilder stringBuilder=new StringBuilder();
        Random r=new Random();
        for(int i=0;i<4;i++){
            char ch=srcCode.charAt(r.nextInt(srcCode.length()));
            stringBuilder.append(ch);
        }
        System.out.println(stringBuilder.toString());
        BufferedImage img=ImgUtils.getCheckImg(stringBuilder.toString());
        ImageIO.write(img,"jpg",response.getOutputStream());
    }
}
