package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.Dao_Change_Email;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.JDBC_Change_Email;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id.Change_Id;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id.Dao_Change_Id;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id.JDBC_Change_Id;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 17.02.2016.
 */
public class Change_id   extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_Change_Id dao_change_id=new JDBC_Change_Id();
        Change_Id change_id=null;
        try {
            change_id=dao_change_id.SelectUserChange_Id(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        String new_id = request.getParameter("new_id");

        try {
            dao_change_id.UpdateId(id, new_id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }



        response.sendRedirect("socc2s/erd/Options.jsp");


    }}