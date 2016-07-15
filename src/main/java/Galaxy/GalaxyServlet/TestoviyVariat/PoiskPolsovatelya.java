package Galaxy.GalaxyServlet.TestoviyVariat;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound.SoundDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;
import Galaxy.UserAccount.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 08.01.2016.
 */
public class PoiskPolsovatelya extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    static String id;
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        System.out.println(id);
        UserDao userDao=(UserDao) Spring.springContext().getBean("userDao");
        User user1=null;
      try {
            user1 = userDao.selectByID(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        request.setAttribute("Userid",user1);
        System.out.println(user1.getlogin());
        this.forward("/socc2s/Polsovatel.jsp?id="+id, request, response);



    }}
