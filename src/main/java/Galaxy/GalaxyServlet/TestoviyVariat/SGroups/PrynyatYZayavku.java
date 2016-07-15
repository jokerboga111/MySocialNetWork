package Galaxy.GalaxyServlet.TestoviyVariat.SGroups;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.DaoGroups;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.DaoGroupsJDBC;
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
 * Created by Admin on 15.01.2016.
 */
public class PrynyatYZayavku  extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String NameGroup=request.getParameter("NameGroup");
        String id=request.getParameter("id");
        String idGroup=request.getParameter("idGroup");
        String idFriend=request.getParameter("idFriend");
        DaoGroups groupDao=(DaoGroups) Spring.springContext().getBean("groupDao");
        try {
            groupDao.deleteGroupAdminZayavka(idFriend,idGroup);
            groupDao.insertNewFriendInGroup(idFriend,NameGroup,idGroup);
            groupDao.insertNewGroupInUser(idGroup,NameGroup,idFriend);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        this.forward("/PoiskZayavka?idZ="+id, request, response);



    }
}
