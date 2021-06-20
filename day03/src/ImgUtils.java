package tompeixun;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImgUtils {
    public static BufferedImage getCheckImg(String code){
        Random r=new Random();
        int width=120;
        int height=40;
        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g=bufferedImage.getGraphics();
        g.setColor(Color.orange);
        g.fillRect(0,0,width,height);
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height);
        for(int i=0;i<6;i++){
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(width),r.nextInt(height),r.nextInt(width),r.nextInt(height));
        }
        g.setFont(new Font("宋体",Font.BOLD,28));
        for(int i=0;i<4;i++){
            String ch=code.charAt(i)+"";
            g.setColor(new Color(r.nextInt(r.nextInt(255)),r.nextInt(255),r.nextInt(255)));
            g.drawString(ch,10+i*28,30);
        }
        return bufferedImage;
    }
}
