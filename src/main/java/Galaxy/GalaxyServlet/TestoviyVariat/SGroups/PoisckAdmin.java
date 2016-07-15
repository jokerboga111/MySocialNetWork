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
import java.util.List;

/**
 * Created by Admin on 15.01.2016.
 */
public class PoisckAdmin extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Groups> map=null;
        String id=request.getParameter("idZA");
        DaoGroups groupDao=(DaoGroups) Spring.springContext().getBean("groupDao");
        try {
            map=groupDao.selectAdminGroupById(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        request.setAttribute("UserZaiAdm",map);
        this.forward("/socc2s/myGroups/admingroup.jsp?id="+id, request, response);



    }
}