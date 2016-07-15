package Galaxy.GalaxyServlet.TestoviyVariat.SSound;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDaoJDBC;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 22.01.2016.
 */
public class SelectMyMusic extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Sound> listSound=null;
        String idUser=request.getParameter("idUser");
        SoundDao ud=(SoundDao) Spring.springContext().getBean("soundDao");
        try {
            listSound=ud.selectSoundByUserId(idUser);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        request.setAttribute("SoundUser",listSound);
        this.forward("/socc2s/MyMusic/MyMusic.jsp?idUser="+idUser, request, response);



    }


}