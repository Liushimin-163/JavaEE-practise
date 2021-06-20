package tompeixun;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "checkCodeServlet",urlPatterns = "/checkCode")
public class checkCodeServlet extends HttpServlet {
    private static final long serialVersionID=1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=120;
        int height=40;
        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics g=bufferedImage.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);
        g.setColor(Color.red);
        g.drawRect(0,0,width-1,height);
        String data="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random r=new Random();
        String code="";
        for(int i=0;i<4;i++){
            g.setFont(new Font("宋体",Font.BOLD,28));
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            String str=data.charAt(r.nextInt(data.length()))+"";
            g.drawString(str,10+i*28,30);
            code=code+str;
        }
        for(int i=0;i<6;i++){
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(width),r.nextInt(height),r.nextInt(width),r.nextInt(height));
        }
        System.out.println(code);
        request.getSession().setAttribute("code_session",code);
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
    }
}
