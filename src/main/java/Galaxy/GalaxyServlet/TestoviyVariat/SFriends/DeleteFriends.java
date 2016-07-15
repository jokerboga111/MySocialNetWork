package Galaxy.GalaxyServlet.TestoviyVariat.SFriends;

import Galaxy.DataBase.DataBaseException.DBSystemException;
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
 * Created by Admin on 11.01.2016.
 */
public class DeleteFriends extends Dispatcher {


    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idf=request.getParameter("idf");
        String id=request.getParameter("id");
        DaoFriend friendDao=
                (DaoFriend) Spring.springContext().getBean("friendDao");
        try {
         friendDao.deleteFriend(id,idf);

        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        this.forward("/PoiskDruzey?idfri="+id, request, response);



    }
}
