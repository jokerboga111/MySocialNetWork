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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Admin on 08.01.2016.
 */
public class ProvercaId extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    static String id;
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       HttpSession ses=request.getSession();
        User user= (User) ses.getAttribute("user");
        String name=user.getlogin();
        UserDao userDao=(UserDao) Spring.springContext().getBean("userDao");
        User user1=null;
        try {
            user1 = userDao.selectByLogin(name);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        System.out.println(user1.getlogin());
        if(name.equals(user1.getlogin())){
            id=user1.getID();
            response.sendRedirect("/socc2s/erd/index.jsp?id="+id);
        }


}}
