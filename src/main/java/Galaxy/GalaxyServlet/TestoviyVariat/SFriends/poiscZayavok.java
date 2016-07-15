package Galaxy.GalaxyServlet.TestoviyVariat.SFriends;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Friends.DaoFriend;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;
import Galaxy.UserAccount.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 11.01.2016.
 */
public class poiscZayavok extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> map=null;
        String id=request.getParameter("idZ");
        UserDao ud=  (UserDao) Spring.springContext().getBean("userDao");
        try {
            map=ud.selectByIDAndLogin(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        request.setAttribute("UserZAI",map);
        this.forward("/socc2s/friends/Orders.jsp?id="+id, request, response);



    }
}
