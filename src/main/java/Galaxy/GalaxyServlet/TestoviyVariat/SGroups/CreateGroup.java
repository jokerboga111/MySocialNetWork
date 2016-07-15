package Galaxy.GalaxyServlet.TestoviyVariat.SGroups;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Friends.DaoFriend;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.DaoGroups;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.DaoGroupsJDBC;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group.Dao_Upravlenye_Group;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group.JDBC_Upravlenye_Group;
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
public class CreateGroup extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idGroup=request.getParameter("IdGroup");
        String NameGroup=request.getParameter("Name");
        String id=request.getParameter("id");
        DaoGroups groupDao=  (DaoGroups) Spring.springContext().getBean("groupDao");
        Dao_Upravlenye_Group upravlenye_group=new JDBC_Upravlenye_Group();
        try {
            groupDao.insertGroup(idGroup,NameGroup);
            groupDao.insertAdminGroup(idGroup,NameGroup,id);
            groupDao.insertNewFriendInGroup(id,NameGroup,idGroup);
            groupDao.insertNewGroupInUser(idGroup,NameGroup,id);
            upravlenye_group.InsertUpravlenye(idGroup,NameGroup);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/socc2s/erd/UpravlenyeGroup.jsp?idGroup="+idGroup+"&NameGroup="+NameGroup+"&idUser="+id);



    }}
