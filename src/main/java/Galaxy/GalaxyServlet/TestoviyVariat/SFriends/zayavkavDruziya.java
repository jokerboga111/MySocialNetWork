package Galaxy.GalaxyServlet.TestoviyVariat.SFriends;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserEmailException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserLoginException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Friends.DaoFriend;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Friends.DaoFriendJDBC;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 10.01.2016.
 */
public class zayavkavDruziya extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idf=request.getParameter("idf");
        String login =request.getParameter("login");
        String id=request.getParameter("id");
        DaoFriend daoFriend=
                (DaoFriend) Spring.springContext().getBean("friendDao");
        try {
            daoFriend.insertNewOrder(idf,login,id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        } catch (NotUniqueUserEmailException e) {
            e.printStackTrace();
        } catch (NotUniqueUserLoginException e) {
            e.printStackTrace();
        }
        this.forward("/poiscPolsovatelya?id="+idf, request, response);



    }
}
