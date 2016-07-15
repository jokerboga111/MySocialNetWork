package Galaxy.GalaxyServlet.TestoviyVariat;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by Admin on 25.12.2015.
 */
public class Send extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("application/jar");
         InputStream in= new FileInputStream(new File((String) request.getAttribute("ImgName")));
        int read=0;
        byte[] bytes=new byte[1024];
        ServletOutputStream out=response.getOutputStream();
        while((read=in.read(bytes))!=-1){
            out.write(bytes,0,read);
        }
        out.flush();
        out.close();
    }
}
