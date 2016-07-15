package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Dao_Ather_Service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page.Ather_page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page.Dao_ather_page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page.JDBC_ather_page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.Change_Pasword;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.Dao_Change_Password;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.JDBC_Change_Password;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 17.02.2016.
 */
public class Ather  extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_ather_page dao_ather_page=new JDBC_ather_page();
        Ather_page ather_page=null;
        try {
            ather_page=dao_ather_page.SelectUserAther_page(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        String who_can_see_my_page= request.getParameter("who_can_see_my_page");
        String what_about_can_see= request.getParameter("what_about_can_see");


                try {
                    dao_ather_page.Update_who_can_see_my_page(id, who_can_see_my_page);
                } catch (DBSystemException e) {
                    e.printStackTrace();
                }
        try {
            dao_ather_page.Update_what_about_can_see(id,what_about_can_see);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        response.sendRedirect("socc2s/erd/Options.jsp");


    }}
