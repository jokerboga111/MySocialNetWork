package Galaxy.GalaxyServlet.TestoviyVariat.SGroups;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserEmailException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserLoginException;
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
public class ZayavkaVGroup  extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idGroup=request.getParameter("idGroup");
        String NameGroup =request.getParameter("NameGroup");
        String idUser=request.getParameter("idUser");
        DaoGroups groupDao=(DaoGroups) Spring.springContext().getBean("groupDao");
        try {
            groupDao.insertNewOrderGroups(idGroup,NameGroup,idUser);
        } catch (DBSystemException e) {
            e.printStackTrace();
        } catch (NotUniqueUserEmailException e) {
            e.printStackTrace();
        } catch (NotUniqueUserLoginException e) {
            e.printStackTrace();
        }
        this.forward("/socc2s/myGroups/group.jsp?idGroup="+idGroup+"&NameGroup="+NameGroup+"&idUser="+idUser, request, response);



    }
}
