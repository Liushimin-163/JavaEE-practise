package demo03_context_read;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readFileUtil {
    public static Properties readFile()
throws IOException{
   InputStream is=readFileUtil.class.getClassLoader().getResourceAsStream("db.properties");
   Properties pros=new Properties();
   pros.load(is);
   return pros;
    }
}
