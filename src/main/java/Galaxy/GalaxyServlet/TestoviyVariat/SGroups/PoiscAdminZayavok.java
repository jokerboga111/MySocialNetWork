package Galaxy.GalaxyServlet.TestoviyVariat.SGroups;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.DaoGroups;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.DaoGroupsJDBC;
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
 * Created by Admin on 15.01.2016.
 */
public class PoiscAdminZayavok extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> map=null;
        String namegroup=request.getParameter("NameGroup");
        String id=request.getParameter("idZ_A");
        DaoGroups groupDao=(DaoGroups) Spring.springContext().getBean("groupDao");
        try {
            map=groupDao.selectAdminZayavkiByIdGroup(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        request.setAttribute("UserZ_A",map);
        this.forward("/socc2s/myGroups/zayavkiGroup.jsp?idGroup="+id+"&NameGroup="+namegroup, request, response);



    }
}
