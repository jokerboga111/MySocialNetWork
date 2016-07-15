package Galaxy.GalaxyServlet.TestoviyVariat;

import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDaoJDBC;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDao;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.UserAccount.User;
import com.ibm.useful.http.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReceiverServlet extends Dispatcher {
    String Img;
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
        try
        {
            //проверка пришел ли запрос в multipart формате
            if(isMultipartFormat(req))
            {//разбор формата multipart и помещение информации из запроса в поля объекта
                //класса PostData
                PostData multidata=new PostData(req);

                //извлечение посланной информации
                String fileDescription=multidata.getParameter("description ");
                FileData tempFile=multidata.getFileData("file_send");

                if(tempFile!=null) saveFile(tempFile);
                PhotoDao dao=(PhotoDao) Spring.springContext().getBean("photoDao");
                HttpSession ses=req.getSession();
                User u= (User) ses.getAttribute("user");
                dao.insertAvatar(u.getID(),tempFile.getFileName());
                this.forward("/socc2s/html.jsp", req, res);

            }}catch(Exception e){System.out.println(e.toString());}

        }

        //функция, проверяющая пришел ли запрос в формате multipart
    private boolean isMultipartFormat(HttpServletRequest req) throws ServletException, IOException
    {
        String temptype=req.getContentType();
        if(temptype.indexOf("multipart/form-data")!=-1) return true;
        else return false;
    }

    //функция, сохраняющая пришедший файл на диск
    private void saveFile(FileData tempFile) throws IOException
    {
        File f = new File("D:/ол/untitled4/web/Photos/" + tempFile.getFileName());
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(tempFile.getByteData());
        fos.close();
    }
}