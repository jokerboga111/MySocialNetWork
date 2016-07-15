package Galaxy.GalaxyServlet.TestoviyVariat.SSound;

import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.DaoGroups;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.PhotoDaoJDBC;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDaoJDBC;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.UserAccount.User;
import com.ibm.useful.http.FileData;
import com.ibm.useful.http.PostData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Admin on 22.01.2016.
 */
public class InsertSound extends Dispatcher

    {
        String Img;
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
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
                User u=null;
               saveFile(tempFile);
                SoundDao dao=(SoundDao) Spring.springContext().getBean("soundDao");
                HttpSession ses=req.getSession();
                u= (User) ses.getAttribute("user");
                dao.insertSound(u.getID(),tempFile.getFileName());
            }
            this.forward("/socc2s/MyMusic/MyMusic.jsp", req, res);
        }catch(Exception e){
            System.out.println(e.toString());}

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
        File f = new File("D:/Sound/" + tempFile.getFileName());
        FileOutputStream fos = new FileOutputStream(f);

        fos.write(tempFile.getByteData());
        System.out.println("Загрузка успешна" );
        fos.close();
    }
}

