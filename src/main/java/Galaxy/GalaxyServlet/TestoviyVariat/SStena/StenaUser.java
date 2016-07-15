package Galaxy.GalaxyServlet.TestoviyVariat.SStena;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.JDBC_User_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.User_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Stena.Dao_Wall;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Stena.JDBC_Wall;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Stena.Wall;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 08.03.2016.
 */
public class StenaUser extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Dao_Wall dao_wall =new JDBC_Wall();
        String id = request.getParameter("id");
        String wall= request.getParameter("wall");
        List<Wall> education= null;
        try {
            dao_wall.insertNewOpisanie(id,wall);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        response.sendRedirect("socc2s/erd/index.jsp");


    }


}
